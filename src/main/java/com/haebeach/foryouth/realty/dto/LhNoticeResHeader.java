package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LhNoticeResHeader {
    @SerializedName("SS_CODE")
    private String ssCode;
    @SerializedName("RS_DTTM")
    private String rsDttm;
}
