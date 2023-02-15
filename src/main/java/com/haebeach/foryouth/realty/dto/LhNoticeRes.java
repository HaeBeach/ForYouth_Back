package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LhNoticeRes {
    @SerializedName("LINK_URL")
    private String linkUrl;
    @SerializedName("PAGE")
    private String page;
    @SerializedName("RNUM")
    private String rnum;
    @SerializedName("BBS_WOU_DTTM")
    private String bbsWouDttm;
    @SerializedName("ALL_CNT")
    private String allCnt;
    @SerializedName("BBS_SN")
    private String bbsSn;
    @SerializedName("BBS_TL")
    private String bbsTl;
    @SerializedName("INQ_CNT")
    private String inqCnt;
    @SerializedName("AIS_TP_CD_NM")
    private String aisTpCdNm;
    @SerializedName("CCR_CNNT_SYS_DS_CD")
    private String ccrCnntSysDsCd;
    @SerializedName("DEP_NM")
    private String depNm;
}
