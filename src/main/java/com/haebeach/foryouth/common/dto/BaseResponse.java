package com.haebeach.foryouth.common.dto;

import lombok.Data;

@Data
public class BaseResponse {

    private String id;
    private String message;
    private Object object;

    public BaseResponse() {
        this.message = "empty message";
        this.id = null;
        this.object = null;
    }

    public BaseResponse(String message, String id) {
        this.message = message;
        this.id = id;
        this.object = null;
    }

    public BaseResponse(String message, Object object) {
        this.message = message;
        this.id = null;
        this.object = object;
    }

}
