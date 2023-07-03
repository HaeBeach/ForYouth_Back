package com.haebeach.foryouth.auth.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GoogleTokenResDto {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private String expiresIn;
    @SerializedName("scope")
    private String scope;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("id_token")
    private String idToken;
}
