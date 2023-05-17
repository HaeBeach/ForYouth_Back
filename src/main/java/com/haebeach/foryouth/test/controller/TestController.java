package com.haebeach.foryouth.test.controller;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.test.dto.BodyTest;
import com.haebeach.foryouth.test.dto.DbTestDto;
import com.haebeach.foryouth.test.entity.DbTest;
import com.haebeach.foryouth.test.repository.DbTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
//@AllArgsConstructor
@RequiredArgsConstructor
public class TestController {

    private final DbTestRepository dbTestRepository;

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

    @GetMapping("/db-test/{seq}")
    @ResponseBody()
    public BaseResponse requestGetDbTest(@PathVariable("seq") int seq) {
        System.out.println("testId : " + seq);

        DbTest dbTest = dbTestRepository.findBySeq(seq);

        return new BaseResponse("success", dbTest);
    }

    @PostMapping("/db-test/{seq}")
    @ResponseBody
    public BaseResponse requestPostDbTest(@PathVariable("seq") String seq, @RequestBody DbTestDto dbTestDto) {
        System.out.println(dbTestDto.toString());
        System.out.println(dbTestDto.getSeq());

        DbTest dbTest = new DbTest();

        dbTest.setSeq(dbTestDto.getSeq());
        dbTest.setName(dbTestDto.getName());
        dbTest.setFirstCretDt(dbTestDto.getFirstCretDt());
        dbTest.setLastChgDt(dbTestDto.getLastChtDt());

        dbTestRepository.save(dbTest);

        return new BaseResponse("success", dbTestDto.getSeq());
    }

}
