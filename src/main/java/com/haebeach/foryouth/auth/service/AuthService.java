package com.haebeach.foryouth.auth.service;

import com.haebeach.foryouth.auth.dto.SignupReqDto;
import com.haebeach.foryouth.auth.entity.User;
import com.haebeach.foryouth.auth.repository.UserRepository;
import com.haebeach.foryouth.common.dto.BaseResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

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

    private boolean validRequest(SignupReqDto signupReqDto) {
        return true;
    }

}
