package com.lp.mvp_network.activity.file;

import android.Manifest;
import android.annotation.SuppressLint;
import android.view.View;

import com.blankj.utilcode.util.FileUtils;
import com.lp.mvp_network.R;
import com.lp.mvp_network.base.BaseActivity;
import com.lp.mvp_network.base.BaseContent;
import com.lp.mvp_network.utils.L;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/6
 */
public class FileActivity extends BaseActivity<FilePresenter> implements FileView, View.OnClickListener {

    @Override
    protected FilePresenter createPresenter() {
        return new FilePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_file;
    }

    @Override
    protected void initData() {
        findViewById(R.id.btn_download).setOnClickListener(this);
    }

    @Override
    public void onFileSuccess(File file) {
        L.e("下载成功,  保存路径=" + file.getAbsolutePath());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //下载
            case R.id.btn_download:
                //初始化权限相关
                initPermission();
                break;
        }
    }

    /**
     * 初始化权限相关
     */
    @SuppressLint("CheckResult")
    private void initPermission() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(@NonNull Boolean granted) throws Exception {
                if (granted) {
                    String url = "https://bjlzbt.com/upload/default//20190725//c13948258c6ef6a36cbe2d3322b98f5c.mp4";
                    if (FileUtils.createOrExistsDir(BaseContent.baseFileName)) {
                        mPresenter.downFile(url, BaseContent.baseFileName, "ceshi.mp4");
                    }
                } else {
                    showToast("部分权限未获取!!");
                }
            }
        });
    }


}
