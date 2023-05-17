package com.haebeach.foryouth.realty.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haebeach.foryouth.common.dto.BaseResponse;
import com.haebeach.foryouth.realty.dto.LhNoticeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LhService {

    @Value("${realty.lh.serviceKey}")
    private String serviceKey;

    public BaseResponse requestLhNotice(String pageSize, String pageNumber) throws IOException {
        log.info("service key : " + serviceKey);
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        log.info("today : " + today);

        String startDt = "2020-01-01";
        String endDt = simpleDateFormat.format(today);

        log.info("Date : " + startDt + " - " + endDt);

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552555/lhNoticeInfo1/getNoticeInfo1"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("PG_SZ","UTF-8") + "=" + URLEncoder.encode(pageSize, "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("SCH_ST_DT","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*기간검색-시작일*/
        urlBuilder.append("&" + URLEncoder.encode("SCH_ED_DT","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*기간검색-종료일*/
        urlBuilder.append("&" + URLEncoder.encode("PAGE","UTF-8") + "=" + URLEncoder.encode(pageNumber, "UTF-8")); /*페이지번호*/

        log.info("Requested url : " + urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.info("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

        Gson gson = new Gson();
        List<LhNoticeDto> lhNoticeDto = gson.fromJson(sb.toString(), new TypeToken<List<LhNoticeDto>>(){}.getType());

        return new BaseResponse("success", lhNoticeDto);
    }

}
