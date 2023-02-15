package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class LhNotice {
    @SerializedName("dsSch")
    private List<LhNoticeReq> dsSch;
    @SerializedName("dsListNm")
    private List<LhNoticeResDesc> dsListNm;
    @SerializedName("resHeader")
    private List<LhNoticeResHeader> resHeader;
    @SerializedName("dsList")
    private List<LhNoticeRes> dsList;
}