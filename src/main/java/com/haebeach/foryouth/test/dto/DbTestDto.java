package com.haebeach.foryouth.test.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class DbTestDto {

    @SerializedName("seq")
    private int seq;

    @SerializedName("name")
    private String name;

    @SerializedName("firstCretDt")
    private Date firstCretDt;

    @SerializedName("lastChgDt")
    private Date lastChtDt;

}
