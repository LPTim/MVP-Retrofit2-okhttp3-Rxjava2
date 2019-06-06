package com.lp.mvp_network.utils;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * File descripition:   RetrofitUtil工具类
 *
 * @author lp
 * @date 2018/8/13
 */

public class RetrofitUtil {
    /**
     * 将String 字符串转换为Rrtorfit: requestBody类型的value
     */
    public static RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = null;
        requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

    /**
     * 将所有的File图片集合转化为retorfit上传图片所需的： MultipartBody.Part类型的集合
     */
    public static List<MultipartBody.Part> filesToMultipartBodyParts(List<File> files, String key) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (File file : files) {
            parts.add(filesToMultipartBodyParts(file, key));
        }
        return parts;
    }

    /**
     * 将单个File图片转化为retorfit上传图片所需的： MultipartBody.Part类型
     */
    public static MultipartBody.Part filesToMultipartBodyParts(File file, String key) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), requestBody);
        return part;
    }

    public static List<File> initImages(List<String> mImages) {
        List<File> listPicture = new ArrayList<>();
        listPicture.clear();
        Iterator<String> stuIter = mImages.iterator();
        while (stuIter.hasNext()) {
            String mUrl = stuIter.next();
            listPicture.add(new File(mUrl));
        }
        return listPicture;
    }
}
