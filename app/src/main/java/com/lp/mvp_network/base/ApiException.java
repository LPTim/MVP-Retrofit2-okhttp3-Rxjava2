package com.lp.mvp_network.base;

/**
 * File descripition:   异常处理基类
 *
 * @author lp
 * @date 2018/8/24
 */

public class ApiException extends RuntimeException {
    private int errorCode;

    public ApiException(int code, String msg) {
        super(msg);
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
