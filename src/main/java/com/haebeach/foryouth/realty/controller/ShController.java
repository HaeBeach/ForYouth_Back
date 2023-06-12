package com.haebeach.foryouth.realty.controller;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.realty.service.ShService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/realty/sh")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ShController {

    private final ShService shService;

    @GetMapping("/pageSize/{pageSize}/pageNumber/{pageNumber}")
    @ResponseBody()
    public BaseResponse requestShNotice(@PathVariable("pageSize") String pageSize,
                                        @PathVariable("pageNumber") String pageNumber) throws IOException {
        return shService.requestShNotice(pageSize, pageNumber);
    }

}
