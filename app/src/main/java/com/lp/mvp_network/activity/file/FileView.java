package com.lp.mvp_network.activity.file;

import com.lp.mvp_network.base.mvp.BaseView;

import java.io.File;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/6
 */
public interface FileView extends BaseView {
    void onFileSuccess(File file);
}
