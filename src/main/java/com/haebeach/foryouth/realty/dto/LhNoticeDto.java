package com.haebeach.foryouth.realty.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class LhNoticeDto {
    @SerializedName("dsSch")
    private List<LhNoticeReqDto> dsSch;
    @SerializedName("dsListNm")
    private List<LhNoticeResDescDto> dsListNm;
    @SerializedName("resHeader")
    private List<LhNoticeResHeaderDto> resHeader;
    @SerializedName("dsList")
    private List<LhNoticeResDto> dsList;
}