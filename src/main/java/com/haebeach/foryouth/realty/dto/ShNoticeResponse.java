package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;

@Data
public class ShNoticeResponse {
    @SerializedName("seq")
    private int seq;            // row 번호
    @SerializedName("title")
    private String title;       // 제목
    @SerializedName("depNm")
    private String depNm;       // 부서명
    @SerializedName("firstCretDt")
    private Date firstCretDt;   // Crawling 일시
    @SerializedName("inqCnt")
    private int inqCnt;
    @SerializedName("rnum")
    private int rnum;           // 검색조건 번호
    @SerializedName("allCnt")
    private String allCnt;      // 총 건수
}
