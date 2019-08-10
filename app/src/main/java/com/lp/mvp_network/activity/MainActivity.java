package com.lp.mvp_network.activity;

import android.view.View;
import android.widget.TextView;

import com.lp.mvp_network.R;
import com.lp.mvp_network.activity.file.FileActivity;
import com.lp.mvp_network.base.BaseActivity;
import com.lp.mvp_network.base.BaseContent;
import com.lp.mvp_network.base.mvp.BaseModel;
import com.lp.mvp_network.bean.TextBean;
import com.lp.mvp_network.utils.L;
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
        findViewById(R.id.btn_second).setOnClickListener(this);
        findViewById(R.id.btn_second_2).setOnClickListener(this);
        findViewById(R.id.btn_third).setOnClickListener(this);
        findViewById(R.id.btn_forth).setOnClickListener(this);
        findViewById(R.id.btn_fifth).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_down).setOnClickListener(this);
        mTvText = findViewById(R.id.tv_text);

        mainBeans = new ArrayList<>();


    }

    @Override
    public void onMainSuccess(BaseModel<List<MainBean>> o) {
//        Log.e(o.getErrmsg(), "");
//        Log.e(o.getErrcode() + "", "");
//        mainBeans.addAll(o.getData());
//        Log.e("sm", mainBeans.toString() + "");
//        mTvText.setText(o.getData().toString());
    }

    @Override
    public void onTextSuccess(BaseModel<TextBean> o) {
        mTvText.setText(o.getResult().getData().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //默认请求
            case R.id.btn_first:
                mPresenter.getTextApi();
                break;
            //上传图片
            case R.id.btn_second:
                showToast("添加本地图片url,再进行测试");
//                upLoadImage();
                break;
            //上传文件进度测试
            case R.id.btn_second_2:
                mPresenter.upLoadVideoApi(BaseContent.baseFileName+"ceshi.mp4");
                break;
            //mvc测试
            case R.id.btn_third:
                startActivity(MvcActivity.class);
                break;
            //多基类测试
            case R.id.btn_forth:
                mPresenter.getTableListApi();
                break;
            //多基类测试
            case R.id.btn_fifth:
                mPresenter.getRestrictionsApi();
                break;
            //多基类测试
            case R.id.btn_six:
                mPresenter.getCheShiApi();
                break;
            //文件上传测试
            case R.id.btn_down:
                startActivity(FileActivity.class);
                break;
        }
    }

    private void upLoadImage() {
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

    }

    @Override
    public void onUpLoadImgSuccess(BaseModel<Object> o) {
        L.e("文件视频路径==" + o.getResult());
    }

    /**
     * 测试多基类
     *
     * @param o
     */
    @Override
    public void onTableListSuccess(BaseModel<Object> o) {
        L.e("测试多基类1=" + o.getResult());
    }

    /**
     * 测试多基类
     *
     * @param o
     */
    @Override
    public void onRestrictionsSuccess(BaseModel<Object> o) {
        L.e("测试多基类2=" + o.getResult());
    }

    @Override
    public void onCheShiSuccess(BaseModel<Object> o) {
        L.e("测试多基类3=" + o.getResult());
    }

}
