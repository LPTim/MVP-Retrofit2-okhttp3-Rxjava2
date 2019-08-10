package com.lp.mvp_network.base.mvp;

import java.io.Serializable;

/**
 * File descripition:   mode基类
 *
 * @author lp
 * @date 2018/6/19
 */
public class BaseModel<T> implements Serializable {
    private String reason;
    private int error_code;
    private T result;

    public BaseModel(String reason, int error_code) {
        this.reason = reason;
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
