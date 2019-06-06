package com.lp.mvp_network.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lp.mvp_network.R;
import com.lp.mvp_network.base.BaseActivity;
import com.lp.mvp_network.base.mvp.BaseModel;
import com.lp.mvp_network.second2demo.activity.SecondActivity;
import com.lp.mvp_network.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView, View.OnClickListener {
    private TextView mTvText;

    private List<MainBean> mainBeans;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


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
    protected void initData() {
        findViewById(R.id.btn_first).setOnClickListener(this);
        findViewById(R.id.btn_third).setOnClickListener(this);
        mTvText = findViewById(R.id.tv_text);

        mainBeans = new ArrayList<>();
    }

    @Override
    public void onMainSuccess(BaseModel<List<MainBean>> o) {
        Log.e(o.getErrmsg(), "");
        Log.e(o.getErrcode() + "", "");
        mainBeans.addAll(o.getData());
        Log.e("sm", mainBeans.toString() + "");
        mTvText.setText(o.getData().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first:
                mPresenter.getMan2Api();
                break;
            case R.id.btn_second:
                /**
                 * 俩个参数  一个是图片集合路径   一个是和后台约定的Key，如果后台不需要，随便写都行
                 */
                List<String> strings = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    strings.add("tupian.lujing");
                }
                mPresenter.upLoadImgApi(
                        "title",
                        "content",
                        RetrofitUtil.filesToMultipartBodyParts(RetrofitUtil.initImages(strings), "tupian.key"));
                break;
            case R.id.btn_third:
                startActivity(SecondActivity.class);
                break;
        }


    }

    @Override
    public void onUpLoadImgSuccess(BaseModel<Object> o) {

    }

}
