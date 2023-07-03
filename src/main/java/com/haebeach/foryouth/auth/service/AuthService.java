package com.haebeach.foryouth.auth.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.haebeach.foryouth.auth.dto.GoogleProfileResDto;
import com.haebeach.foryouth.auth.dto.GoogleTokenReqDto;
import com.haebeach.foryouth.auth.dto.GoogleTokenResDto;
import com.haebeach.foryouth.auth.dto.SignupReqDto;
import com.haebeach.foryouth.auth.entity.User;
import com.haebeach.foryouth.auth.repository.UserRepository;
import com.haebeach.foryouth.common.dto.BaseResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${google.request-token-url}")
    private String requestGoogleTokenUrl;

    @Value("${google.request-profile-url}")
    private String requestGoogleProfileUrl;

    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.secret-key}")
    private String secretKey;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    @Value("${google.grant-type}")
    private String grantType;

    private String roles = "ROLE_USER";

    public BaseResponse requestSignup(SignupReqDto signupReqDto) {
        if (!validRequest(signupReqDto)) {
            log.error("bad request");
            return new BaseResponse("E", "bad request");
        }

        try {
            User user = User.builder()
                    .id(signupReqDto.getId())
                    .password(passwordEncoder.encode(signupReqDto.getPassword()))
                    .email(signupReqDto.getEmail())
                    .birthDay(signupReqDto.getBirthDay())
                    .gender(signupReqDto.getGender())
                    .address(signupReqDto.getAddress())
                    .roles(this.roles)
                    .build();
            userRepository.save(user);
        }
        catch (Exception e) {
            log.error("error : {}", e.toString());
            return new BaseResponse("E", "internal server error");
        }
        return new BaseResponse("S", "signup successfully");
    }

    public BaseResponse requestGoogleToken(GoogleTokenReqDto googleTokenReqDto) throws IOException {
        log.info("=====requestGoogleToken=====");
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", googleTokenReqDto.getCode());
        jsonObject.addProperty("client_id", this.clientId);
        jsonObject.addProperty("client_secret", this.secretKey);
        jsonObject.addProperty("redirect_uri", this.redirectUri);
        jsonObject.addProperty("grant_type", this.grantType);
        String requestBody = gson.toJson(jsonObject);

        URL url = new URL(this.requestGoogleTokenUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "application/json");
        conn.setDoOutput(true);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write(requestBody);
        bw.flush();
        bw.close();

        log.info("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.info(sb.toString());
        GoogleTokenResDto googleTokenResDto = gson.fromJson(sb.toString(), new TypeToken<GoogleTokenResDto>(){}.getType());
        log.info(googleTokenResDto.toString());









        log.info("access_token : " + googleTokenResDto.getAccessToken());

        String requestProfileUrl = this.requestGoogleProfileUrl + "?access_token="
                + googleTokenResDto.getAccessToken();

        URL urlProfile = new URL(requestProfileUrl);
        HttpURLConnection connProfile = (HttpURLConnection) urlProfile.openConnection();
        connProfile.setRequestMethod("GET");
        connProfile.setRequestProperty("Content-type", "application/json");
        connProfile.setDoOutput(true);

        log.info("Response code: " + connProfile.getResponseCode());
        BufferedReader rdProfile;
        if (connProfile.getResponseCode() >= 200 && connProfile.getResponseCode() <= 300) {
            rdProfile = new BufferedReader(new InputStreamReader(connProfile.getInputStream()));
        } else {
            rdProfile = new BufferedReader(new InputStreamReader(connProfile.getErrorStream()));
        }
        StringBuilder sbProfile = new StringBuilder();
        String lineProfile;
        while ((lineProfile = rdProfile.readLine()) != null) {
            sbProfile.append(lineProfile);
        }
        rdProfile.close();
        connProfile.disconnect();

        log.info(sbProfile.toString());
        GoogleProfileResDto googleProfileResDto = gson.fromJson(sbProfile.toString(), new TypeToken<GoogleProfileResDto>(){}.getType());
        log.info(googleProfileResDto.toString());
        return new BaseResponse("S", googleProfileResDto);
    }

    private boolean validRequest(SignupReqDto signupReqDto) {
        return true;
    }

}
