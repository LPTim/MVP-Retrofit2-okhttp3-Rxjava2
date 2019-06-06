package com.lp.mvp_network.second2demo.mvp;

import java.io.Serializable;

/**
 * File descripition:   mode基类
 *
 * @author lp
 * @date 2018/6/19
 */
public class BaseModel<T1,T2,T3> implements Serializable {
    private Boolean success;
    private String request_time;
    private String message;
    private String error;
    private T1 data;
    private T2 additional_data;
    private T3 related_objects;

    public BaseModel(Boolean success, String request_time) {
        this.success = success;
        this.request_time = request_time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getRequest_time() {
        return request_time;
    }

    public void setRequest_time(String request_time) {
        this.request_time = request_time;
    }

    public T1 getData() {
        return data;
    }

    public void setData(T1 data) {
        this.data = data;
    }

    public T2 getAdditional_data() {
        return additional_data;
    }

    public void setAdditional_data(T2 additional_data) {
        this.additional_data = additional_data;
    }

    public T3 getRelated_objects() {
        return related_objects;
    }

    public void setRelated_objects(T3 related_objects) {
        this.related_objects = related_objects;
    }

}
