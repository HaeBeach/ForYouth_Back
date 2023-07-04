package com.haebeach.foryouth.auth.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GoogleTokenReqDto {

    @SerializedName("code")
    private String code;

}
