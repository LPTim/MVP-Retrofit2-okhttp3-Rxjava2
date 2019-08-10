package com.lp.mvp_network;

import android.app.Application;
import android.content.Context;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * File descripition:   运用此项目时，修改地方如下
 * <p>
 * 1.BaseContent 中 baseUrl修改
 * 2.BaseContent 中 basecode修改
 * 3.BaseModel 中 各字段参数名 修改为接口对应
 * 备注：(接口如果复杂，自己修改不了，可以联系我)
 *
 *
 * @author lp
 * @date 2018/10/11
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // 在 Application 中初始化
        ToastUtils.init(this);

        mContext = this;
        initLogger();
    }

    public static Context getContext() {
        return mContext;
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // 是否显示线程信息 默认显示 上图Thread Infrom的位置
                .methodCount(0)         // 展示方法的行数 默认是2  上图Method的行数
                .methodOffset(7)        // 内部方法调用向上偏移的行数 默认是0
//                .logStrategy(customLog) // 改变log打印的策略一种是写本地，一种是logcat显示 默认是后者（当然也可以自己定义）
                .tag("mvp_network_tag")   // 自定义全局tag 默认：PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
    }
}
