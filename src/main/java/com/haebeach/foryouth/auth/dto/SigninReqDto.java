package com.haebeach.foryouth.auth.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SigninReqDto {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

}
