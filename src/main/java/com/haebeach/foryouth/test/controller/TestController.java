package com.haebeach.foryouth.test.controller;

import com.haebeach.foryouth.test.dto.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@AllArgsConstructor
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/getTest/{testId}")
    @ResponseBody()
    public BaseResponse requestTest(@PathVariable("testId") String testId) {
        System.out.println("testId : " + testId);
        return new BaseResponse("success", testId);
    }

}
