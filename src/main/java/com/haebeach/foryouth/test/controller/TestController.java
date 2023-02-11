package com.haebeach.foryouth.test.controller;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.test.dto.BodyTest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
//@AllArgsConstructor
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/getTest/{testId}")
    @ResponseBody()
    public BaseResponse requestTest(@PathVariable("testId") String testId) {
        System.out.println("testId : " + testId);
        return new BaseResponse("success", testId);
    }

    @PostMapping("/postTest/{testId}")
    @ResponseBody
    public BaseResponse requestPostTest(@PathVariable("testId") String testId, @RequestBody BodyTest bodyTest) {
        System.out.println(bodyTest.toString());
        System.out.println(bodyTest.getId());
        return new BaseResponse("success", bodyTest.getId());
    }

}
