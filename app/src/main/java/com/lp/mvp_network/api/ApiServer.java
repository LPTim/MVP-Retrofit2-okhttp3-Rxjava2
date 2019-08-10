package com.lp.mvp_network.api;


import com.lp.mvp_network.activity.MainBean;
import com.lp.mvp_network.base.mvp.BaseModel;
import com.lp.mvp_network.bean.TextBean;
import com.lp.mvp_network.second2demo.bean.Bean1;
import com.lp.mvp_network.second2demo.bean.Bean2;
import com.lp.mvp_network.second2demo.bean.Bean3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface ApiServer {

    /**
     * 大文件官方建议用 @Streaming 来进行注解，不然会出现IO异常，小文件可以忽略不注入
     */
    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);


    /**
     * 客户标签的筛选项
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/api/table_list/")
    Observable<BaseModel<Object>> getTableList(@FieldMap HashMap<String, String> params);
    /**
     * 当前城市限行
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/restrictions/")
    Observable<BaseModel<Object>> getRestrictions(@FieldMap HashMap<String, String> params);
    /**
     * 当前城市限行
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/api/public/banners")
    Observable<BaseModel<Object>> getCeShi(@FieldMap HashMap<String, String> params);


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
     * text
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("index?")
    Observable<BaseModel<TextBean>> getText(@FieldMap HashMap<String, String> params);

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
     * 上传图片/视频
     * <p>
     * //     * @param token 用户登录的token
     * //     * @param file  文件流
     *
     * @return
     */
    @Multipart
    @POST("/wxapp/public/upload")
    Observable<BaseModel<Object>> getUpload(@PartMap Map<String, RequestBody> map,
                                            @Part MultipartBody.Part parts
    );


    /**
     * 演示特殊结构写法
     *
     * @param requestType
     * @return
     */
    @POST("api/Activity/get_activities?")
    Observable<com.lp.mvp_network.second2demo.mvp.BaseModel<List<Bean1>, Bean2, List<Bean3>>> getMain2Demo(@Query("time") String requestType);

    /**
     * 演示特殊结构写法
     *
     * @return
     */
    @FormUrlEncoded
    @POST("api/Activity/get_activities?")
    Observable<com.lp.mvp_network.second2demo.mvp.BaseModel<List<Bean1>, Bean2, List<Bean3>>> getMain3Demo(@FieldMap HashMap<String, String> params);

}
