package com.shan.erpadmin.exception;

public class NewsListException extends RuntimeException {
    private Integer code;

    public NewsListException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
