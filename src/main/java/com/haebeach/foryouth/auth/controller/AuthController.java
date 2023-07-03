package com.haebeach.foryouth.auth.controller;

import com.haebeach.foryouth.auth.dto.GoogleTokenReqDto;
import com.haebeach.foryouth.auth.dto.SignupReqDto;
import com.haebeach.foryouth.auth.service.AuthService;
import com.haebeach.foryouth.common.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public BaseResponse requestSignup(@RequestBody SignupReqDto signupReqDto) {
        return authService.requestSignup(signupReqDto);
    }

    @PostMapping("/google/getToken")
    public BaseResponse requestGoogleToken(@RequestBody GoogleTokenReqDto googleTokenReqDto) throws IOException {
        return authService.requestGoogleToken(googleTokenReqDto);
    }

}
