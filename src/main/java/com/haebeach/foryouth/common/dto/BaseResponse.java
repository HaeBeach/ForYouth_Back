package com.haebeach.foryouth.common.dto;

import lombok.Data;

@Data
public class BaseResponse {

    private String id;
    private String message;

    public BaseResponse() {
        this.message = "empty message";
        this.id = null;
    }

    public BaseResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }

}
