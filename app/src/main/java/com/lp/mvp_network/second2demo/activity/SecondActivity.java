package com.lp.mvp_network.second2demo.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lp.mvp_network.R;
import com.lp.mvp_network.second2demo.BaseActivity;
import com.lp.mvp_network.second2demo.bean.Bean1;
import com.lp.mvp_network.second2demo.bean.Bean2;
import com.lp.mvp_network.second2demo.bean.Bean3;
import com.lp.mvp_network.second2demo.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends BaseActivity<SecondPresenter> implements SecondView, View.OnClickListener {
    private TextView mTvText;


    @Override
    public void onErrorCode(BaseModel model) {
//        super.onErrorCode(model);
        //我要自定义
        //实现自己的逻辑
    }

    @Override
    public void showError(String msg) {
        if (msg.contains("重新登录")) {
//处理自己定制逻辑
        } else {
            super.showError(msg);
        }

    }

    @Override
    protected SecondPresenter createPresenter() {
        return new SecondPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        findViewById(R.id.btn_first).setOnClickListener(this);
        TextView btn_third = findViewById(R.id.btn_third);
        btn_third.setVisibility(View.GONE);
        mTvText = findViewById(R.id.tv_text);

    }
/*
    @Override
    public void onMainSuccess(BaseModel<List<MainBean>> o) {
        Log.e(o.getErrmsg(), "");
        Log.e(o.getErrcode()+"", "");
        mainBeans.addAll(o.getData());
        Log.e("sm", mainBeans.toString()+"");
        mTvText.setText(o.getData().toString());
    }*/

    @Override
    public void onMainSuccess(BaseModel<List<Bean1>, Bean2, List<Bean3>> o) {
        Log.e("成功", ">>>>>>>>>>>>>>");
        mTvText.setText("成功");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first:
                mPresenter.getManApi();
                break;
            case R.id.btn_second:
                /*
                *//**
             * 俩个参数  一个是图片集合路径   一个是和后台约定的Key，如果后台不需要，随便写都行
             *//*
                List<String> strings = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    strings.add("tupian.lujing");
                }
                mPresenter.expressAdd(
                        "title",
                        "content",
                        RetrofitUtil.filesToMultipartBodyParts(RetrofitUtil.initImages(strings), "tupian.key"));
                break;*/
        }


    }


/*
    @Override
    public void onUpLoadImgSuccess(BaseModel<Object> o) {

    }

    @Override
    public void onUpHeadImgSuccess(BaseModel<Object> o) {

    }

    @Override
    public void onExpressAddSuccess(BaseModel<Object> o) {

    }
*/


}
