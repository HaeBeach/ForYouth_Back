package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LhNoticeResponse {
    @SerializedName("linkUrl")
    private String linkUrl;         // 공지사항상세URL
    @SerializedName("page")
    private String page;            // 페이지번호
    @SerializedName("rnum")
    private String rnum;            // 순번
    @SerializedName("bbsWouDttm")
    private String bbsWouDttm;      // 등록일
    @SerializedName("allCnt")
    private String allCnt;          // 전체조회건수
    @SerializedName("bbsSn")
    private String bbsSn;           // 번호
    @SerializedName("bbsTl")
    private String bbsTl;           // 제목
    @SerializedName("inqCnt")
    private String inqCnt;          // 조회수
    @SerializedName("aisTpCdNm")
    private String aisTpCdNm;       // 유형
    @SerializedName("ccrCnntSysDsCd")
    private String ccrCnntSysDsCd;  // 고객센터연계시스템구분코드
    @SerializedName("depNm")
    private String depNm;           // 담당부서


}
