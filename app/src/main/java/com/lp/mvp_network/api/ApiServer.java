package com.lp.mvp_network.api;


import com.lp.mvp_network.activity.MainBean;
import com.lp.mvp_network.base.mvp.BaseModel;
import com.lp.mvp_network.second2demo.bean.Bean1;
import com.lp.mvp_network.second2demo.bean.Bean2;
import com.lp.mvp_network.second2demo.bean.Bean3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface ApiServer {

    /**
     * 第一种写法
     *
     * @param requestType
     * @return
     */
    @POST("api/Activity/get_activities?")
    Observable<BaseModel<List<MainBean>>> getMain(@Query("time") String requestType);

    /**
     * 第二种写法
     *
     * @param requestType
     * @return
     */
    @FormUrlEncoded
    @POST("api/Activity/get_activities?")
    Observable<BaseModel<List<MainBean>>> getMain2(@Field("time") String requestType);

    /**
     * 第三种写法
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api/Activity/get_activities?")
    Observable<BaseModel<HashMap<String, String>>> getMain3(@FieldMap HashMap<String, String> params);

    /**
     * 演示 单图上传
     *
     * @param parts
     * @return
     */
    @Multipart
    @POST("api/Company/register")
    Observable<BaseModel<Object>> upLoadImg(@Part MultipartBody.Part parts);

    /**
     * 演示 多图上传
     *
     * @param parts
     * @return
     */
    @Multipart
    @POST("api/user_info/update_headimg")
    Observable<BaseModel<Object>> upHeadImg(@Part List<MultipartBody.Part> parts);

    /**
     * 演示 图片字段一起上传
     *
     * @param parts
     * @return
     */
    @Multipart
    @POST("api/Express/add")
    Observable<BaseModel<Object>> expressAdd(@PartMap Map<String, RequestBody> map,
                                             @Part List<MultipartBody.Part> parts);



    /**
     * 演示特殊结构写法
     *
     * @param requestType
     * @return
     */
    @POST("api/Activity/get_activities?")
    Observable<com.lp.mvp_network.second2demo.mvp.BaseModel<List<Bean1>, Bean2, List<Bean3>>> getMain2Demo(@Query("time") String requestType);
}
