package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LhNoticeReqDto {
    @SerializedName("PAGE")
    private String page;
    @SerializedName("SCH_ST_DT")
    private String schStDt;
    @SerializedName("SL_BBS_KD_CD")
    private String slBbsKdCd;
    @SerializedName("PG_SZ")
    private String pgSz;
    @SerializedName("SCH_ED_DT")
    private String schEdDt;
    @SerializedName("MMLY_VW")
    private String mmlyVw;
}
