package com.haebeach.foryouth.realty.service;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.realty.entity.LhNoticeRes;
import com.haebeach.foryouth.realty.repository.LhNoticeResRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LhService {

    private final LhNoticeResRepository lhNoticeResRepository;

    public BaseResponse requestLhNotice(String pageSize, String pageNumber) throws IOException {
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        log.info("today : " + today);

        int intPageSize = Integer.parseInt(pageSize);
        int intPageNumber = Integer.parseInt(pageNumber);
        int startSeq = ((intPageNumber - 1) * intPageSize) + 1;
        int endSeq = ((intPageNumber - 1) * intPageSize) + intPageSize;

        log.info("start : " + startSeq + ", end : " + endSeq);

        List<LhNoticeRes> listLhNoticeRes = lhNoticeResRepository.findAllByRnumBetween(startSeq, endSeq);
        return new BaseResponse("success", listLhNoticeRes);
    }

}
