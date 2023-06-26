package com.haebeach.foryouth.auth.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SignupReqDto {

    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    @SerializedName("birthDay")
    private String birthDay;

    @SerializedName("gender")
    private String gender;

    @SerializedName("address")
    private String address;

}
