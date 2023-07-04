package com.haebeach.foryouth.auth.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GoogleProfileResDto {
    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("verified_email")
    private Boolean verifiedEmail;
    @SerializedName("name")
    private String name;
    @SerializedName("given_name")
    private String givenName;
    @SerializedName("family_name")
    private String familyName;
    @SerializedName("locale")
    private String locale;
}
