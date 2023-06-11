package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ShNoticeDto {

    @SerializedName("resultCd")
    private String resultCd;

    @SerializedName("errMsg")
    private String errMsg;

}
