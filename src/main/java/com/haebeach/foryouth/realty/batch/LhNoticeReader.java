package com.haebeach.foryouth.realty.batch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haebeach.foryouth.realty.dto.LhNoticeDto;
import com.haebeach.foryouth.realty.dto.LhNoticeResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
@Component
@JobScope
public class LhNoticeReader implements ItemReader {

    @Value("${realty.lh.serviceKey}")
    private String serviceKey;

    @Value("${realty.lh.noticeApiUrl}")
    private String lhApiUrl;

    private String startDt = "2020-01-01";
    private String endDt;

    private List<LhNoticeDto> lhNoticeDtoAll;
    private int page = 1;
    private int totalSize;
    private int chunkSize = 1000;
    private int index = 0;
    private int seq;

    private boolean initFlag = false;

    @Override
    public LhNoticeResDto read() throws Exception {
        LhNoticeResDto lhNoticeResDto = new LhNoticeResDto();

        if (this.initFlag == false) {
            init();
            if (this.page == 1)
                this.seq = Integer.parseInt(lhNoticeDtoAll.get(1).getDsList().get(0).getAllCnt());
            this.page++;
            this.index = 0;
            this.initFlag = true;
        }
        if (this.index < this.totalSize) {
            lhNoticeResDto = lhNoticeDtoAll.get(1).getDsList().get(this.index);
            lhNoticeResDto.setSeq(this.seq);
            this.seq--;
            this.index++;
        }
        else {
            log.info("empty");
            return null;
        }

        if (this.totalSize == this.chunkSize && this.index == this.totalSize)
            this.initFlag = false;
        return lhNoticeResDto;
    }

    private void init() throws IOException {
        log.info("=====init=====");
        log.info("page : " + this.page);
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        this.endDt = simpleDateFormat.format(today);

        StringBuilder urlBuilder = new StringBuilder(lhApiUrl); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + this.serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("PG_SZ","UTF-8") + "=" + URLEncoder.encode(Integer.toString(this.chunkSize), "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("SCH_ST_DT","UTF-8") + "=" + URLEncoder.encode(this.startDt, "UTF-8")); /*기간검색-시작일*/
        urlBuilder.append("&" + URLEncoder.encode("SCH_ED_DT","UTF-8") + "=" + URLEncoder.encode(this.endDt, "UTF-8")); /*기간검색-종료일*/
        urlBuilder.append("&" + URLEncoder.encode("PAGE","UTF-8") + "=" + URLEncoder.encode(Integer.toString(this.page), "UTF-8")); /*페이지번호*/

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

        Gson gson = new Gson();
        this.lhNoticeDtoAll = gson.fromJson(sb.toString(), new TypeToken<List<LhNoticeDto>>(){}.getType());
        this.totalSize = lhNoticeDtoAll.get(1).getDsList().size();
        log.info("page size : " + this.totalSize);
    }

}
