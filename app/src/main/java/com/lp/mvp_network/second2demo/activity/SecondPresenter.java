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
}
