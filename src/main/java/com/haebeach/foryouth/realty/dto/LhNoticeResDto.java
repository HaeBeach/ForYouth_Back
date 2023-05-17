package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LhNoticeResDto {
    @SerializedName("LINK_URL")
    private String linkUrl;         // 공지사항상세URL
    @SerializedName("PAGE")
    private String page;            // 페이지번호
    @SerializedName("RNUM")
    private String rnum;            // 순번
    @SerializedName("BBS_WOU_DTTM")
    private String bbsWouDttm;      // 등록일
    @SerializedName("ALL_CNT")
    private String allCnt;          // 전체조회건수
    @SerializedName("BBS_SN")
    private String bbsSn;           // 번호
    @SerializedName("BBS_TL")
    private String bbsTl;           // 제목
    @SerializedName("INQ_CNT")
    private String inqCnt;          // 조회수
    @SerializedName("AIS_TP_CD_NM")
    private String aisTpCdNm;       // 유형
    @SerializedName("CCR_CNNT_SYS_DS_CD")
    private String ccrCnntSysDsCd;  // 고객센터연계시스템구분코드
    @SerializedName("DEP_NM")
    private String depNm;           // 담당부서

    private int seq;
}
