package com.techstore.estore.dto.response;


public class BaseResponse<T> {

    private T data;
    private String message;
    private Integer status;

    public BaseResponse() {}

    public BaseResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public BaseResponse(T data, String message, Integer status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
