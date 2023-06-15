package com.haebeach.foryouth.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {

    private String resCd;
    private String message;
    private Object object;

    public BaseResponse() {
        this.resCd = null;
        this.message = "empty message";
        this.object = null;
    }

    public BaseResponse(String resCd, String message) {
        this.resCd = resCd;
        this.message = message;
        this.object = null;
    }

    public BaseResponse(String resCd, Object object) {
        this.resCd = resCd;
        this.message = "";
        this.object = object;
    }

}
