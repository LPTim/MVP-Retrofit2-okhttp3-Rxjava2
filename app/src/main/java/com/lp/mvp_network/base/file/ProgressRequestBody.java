package com.lp.mvp_network.base.file;

import android.os.Handler;
import android.os.Looper;

import com.lp.mvp_network.base.mvp.BaseView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * File descripition: 文件上传
 *
 * @author lp
 * @date 2019/8/10
 */
public class ProgressRequestBody extends RequestBody {
    private File mFile;
    private String mPath;
    private String mMediaType;
    private BaseView mListener;

    private int mEachBufferSize = 1024;

    public ProgressRequestBody(final File file, String mediaType, BaseView baseView) {
        mFile = file;
        mMediaType = mediaType;
        mListener = baseView;
    }

    public ProgressRequestBody(final File file, String mediaType, int eachBufferSize, BaseView baseView) {
        mFile = file;
        mMediaType = mediaType;
        mEachBufferSize = eachBufferSize;
        mListener = baseView;
    }

    @Override
    public MediaType contentType() {
        // i want to upload only images
        return MediaType.parse(mMediaType);
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        long fileLength = mFile.length();
        byte[] buffer = new byte[mEachBufferSize];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;

        try {
            int read;
            Handler handler = new Handler(Looper.getMainLooper());
            while ((read = in.read(buffer)) != -1) {
                // update progress on UI thread
                handler.post(new ProgressUpdater(uploaded, fileLength));
                uploaded += read;
                sink.write(buffer, 0, read);

            }
        } finally {
            in.close();
        }
    }

    private class ProgressUpdater implements Runnable {
        private long mUploaded;
        private long mTotal;

        public ProgressUpdater(long uploaded, long total) {
            mUploaded = uploaded;
            mTotal = total;
        }

        @Override
        public void run() {
            mListener.onProgress((int) (100 * mUploaded / mTotal));
        }
    }
}
