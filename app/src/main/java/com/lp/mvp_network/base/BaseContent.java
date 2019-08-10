package com.lp.mvp_network.base;

import android.os.Environment;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public class BaseContent {
    //base Ip
    public static String baseUrl = "http://v.juhe.cn/toutiao/";
    //视频文件存储路径
    public static String baseFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "mvp_network/";
    //服务器返回成功的 cdoe
    public static int basecode = 0;
}
