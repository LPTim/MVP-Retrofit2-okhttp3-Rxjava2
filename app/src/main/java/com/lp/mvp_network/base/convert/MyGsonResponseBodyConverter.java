package com.lp.mvp_network.base.convert;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.lp.mvp_network.base.ApiException;
import com.lp.mvp_network.base.BaseContent;
import com.lp.mvp_network.base.mvp.BaseModel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;


/**
 * File descripition:   重写gson 判断返回值  状态划分
 * <p>
 * 此处很重要
 * 为何这样写：因为开发中有这样的需求   当服务器返回假如0是正常 1是不正常  0我们gson 或 fastJson解析数据
 * 1我们不想解析（可能返回值出现以前是对象 数据为空变成了数组等等，于是在不改后台代码的情况下  我们前端需要处理）
 * 但是用了插件之后没有很有效的方法控制解析 所以处理方式为  当服务器返回不等于0时候  其他状态都抛出异常 然后提示
 * <p>
 * <p>
 * 此处为如果在解析这一步拦截  可采取这种方式
 *
 * @author lp
 * @date 2018/8/24
 */

final class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseModel re = gson.fromJson(response, BaseModel.class);
        //关注的重点，自定义响应码中非0的情况，一律抛出ApiException异常。
        //这样，我们就成功的将该异常交给onError()去处理了。
        if (re.getErrcode() != BaseContent.basecode) {
            value.close();
            throw new ApiException(re.getErrcode(), re.getErrmsg());
        }

        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());
        InputStreamReader reader = new InputStreamReader(bis, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
