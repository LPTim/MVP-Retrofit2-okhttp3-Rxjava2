package com.lp.mvp_network.activity;


import com.lp.mvp_network.base.mvp.BaseModel;
import com.lp.mvp_network.base.mvp.BaseView;
import com.lp.mvp_network.bean.TextBean;

import java.util.List;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface MainView extends BaseView {
    void onMainSuccess(BaseModel<List<MainBean>> o);
    void onTextSuccess(BaseModel<TextBean> o);

    void onUpLoadImgSuccess(BaseModel<Object> o);
    void onTableListSuccess(BaseModel<Object> o);
    void onRestrictionsSuccess(BaseModel<Object> o);
    void onCheShiSuccess(BaseModel<Object> o);

}
