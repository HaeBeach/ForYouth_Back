package com.haebeach.foryouth.realty.controller;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.realty.service.LhService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/realty/lh")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class LhController {

    private final LhService lhService;

    @GetMapping("/pageSize/{pageSize}/pageNumber/{pageNumber}")
    @ResponseBody()
    public BaseResponse requestLhNotice(@PathVariable("pageSize") String pageSize,
                                        @PathVariable("pageNumber") String pageNumber) throws IOException {
        return lhService.requestLhNotice(pageSize, pageNumber);
    }

}
