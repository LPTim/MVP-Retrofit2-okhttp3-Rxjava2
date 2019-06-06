package com.lp.mvp_network.second2demo.activity;


import com.lp.mvp_network.second2demo.bean.Bean1;
import com.lp.mvp_network.second2demo.bean.Bean2;
import com.lp.mvp_network.second2demo.bean.Bean3;
import com.lp.mvp_network.second2demo.mvp.BaseModel;
import com.lp.mvp_network.second2demo.mvp.BaseObserver;
import com.lp.mvp_network.second2demo.mvp.BasePresenter;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public class SecondPresenter extends BasePresenter<SecondView> {
    public SecondPresenter(SecondView baseView) {
        super(baseView);
    }

    /**
     * 写法好多种  怎么顺手怎么来
     */
    public void getManApi() {
        addDisposable(apiServer.getMain2Demo("year"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.onMainSuccess((BaseModel<List<Bean1>, Bean2, List<Bean3>>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }
    /*
    *//**
     * 写法好多种  怎么顺手怎么来
     *//*
    public void getManApi() {
        addDisposable(apiServer.getMain("year"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.onMainSuccess((BaseModel<List<MainBean>>) o);
            }
            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }
    *//**
     * 写法好多种  怎么顺手怎么来
     *//*
    public void getMan2Api() {
        addDisposable(apiServer.getMain2("year"), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.onMainSuccess((BaseModel<List<MainBean>>) o);
            }
            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }

    *//**
     * 写法好多种  怎么顺手怎么来
     *//*
    public void getMan3Api() {
        HashMap<String, String> params = new HashMap<>();
        params.put("time", "year");
        addDisposable(apiServer.getMain3(params), new BaseObserver(baseView) {

            @Override
            public void onSuccess(BaseModel o) {
                baseView.onMainSuccess((BaseModel<List<MainBean>>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }


    *//*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  图片上传  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*//*
    *//**
     * 单图上传
     * @param parts
     *//*
    public void upLoadImgApi(MultipartBody.Part parts) {
        addDisposable(apiServer.upLoadImg(parts), new BaseObserver(baseView) {

            @Override
            public void onSuccess(BaseModel o) {
                baseView.onUpLoadImgSuccess((BaseModel<Object>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }


    public void upHeadImgApi(List<MultipartBody.Part> parts) {
        addDisposable(apiServer.upHeadImg(parts), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.onUpHeadImgSuccess((BaseModel<Object>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }

    public void expressAdd(String title, String content, List<MultipartBody.Part> parts) {
        HashMap<String, RequestBody> params = new HashMap<>();
        params.put("title", RetrofitUtil.convertToRequestBody(title));
        params.put("content", RetrofitUtil.convertToRequestBody(content));
        addDisposable(apiServer.expressAdd(params, parts), new BaseObserver(baseView) {
            @Override
            public void onSuccess(BaseModel o) {
                baseView.onExpressAddSuccess((BaseModel<Object>) o);
            }
            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }*/
}
