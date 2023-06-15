package com.haebeach.foryouth.realty.service;

import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.realty.dto.LhNoticeResponse;
import com.haebeach.foryouth.realty.dto.ShNoticeResponse;
import com.haebeach.foryouth.realty.entity.LhNoticeRes;
import com.haebeach.foryouth.realty.entity.ShNoticeRes;
import com.haebeach.foryouth.realty.repository.ShNoticeResRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShService {

    private final ShNoticeResRepository shNoticeResRepository;

    public BaseResponse requestShNotice(String pageSize, String pageNumber) {
        try {
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
            log.info("today : " + today);

            int intPageSize = Integer.parseInt(pageSize);
            int intPageNumber = Integer.parseInt(pageNumber);
            int startSeq = ((intPageNumber - 1) * intPageSize) + 1;
            int endSeq = ((intPageNumber - 1) * intPageSize) + intPageSize;

            log.info("start : " + startSeq + ", end : " + endSeq);

            ModelMapper modelMapper = new ModelMapper();
            List<ShNoticeRes> listShNoticeRes = shNoticeResRepository.findAllByRnumBetween(startSeq, endSeq);
            List<ShNoticeResponse> listShNoticeResponse = listShNoticeRes.stream().map(p -> modelMapper.map(p, ShNoticeResponse.class)).collect(Collectors.toList());
            return new BaseResponse("S", listShNoticeResponse);
        }
        catch (Exception e) {
            log.error(e.toString());
        }

        return new BaseResponse("E", "Internal Server Error");
    }

}
