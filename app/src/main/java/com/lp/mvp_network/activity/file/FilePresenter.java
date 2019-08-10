package com.lp.mvp_network.activity.file;

import com.lp.mvp_network.api.ApiRetrofit;
import com.lp.mvp_network.api.ApiServer;
import com.lp.mvp_network.base.file.FileUtil;
import com.lp.mvp_network.base.file.FileObserver;
import com.lp.mvp_network.base.mvp.BasePresenter;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/8/6
 */
public class FilePresenter extends BasePresenter<FileView> {

    public FilePresenter(FileView baseView) {
        super(baseView);
    }

    public void downFile(String url, final String destFileDir, final String destFileName) {
        ApiServer apiServer = ApiRetrofit.getFileInstance(baseView).getApiService();
        Observable<String> observable = apiServer.downloadFile(url).map(new Function<ResponseBody, String>() {
            @Override
            public String apply(ResponseBody body) throws Exception {
                File file = FileUtil.saveFile(destFileDir+destFileName, body);
                return file.getPath();
            }
        });
        addFileDisposable(observable, new FileObserver(baseView) {
            @Override
            public void onSuccess(Object o) {
                baseView.onFileSuccess(new File(o.toString()));
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
