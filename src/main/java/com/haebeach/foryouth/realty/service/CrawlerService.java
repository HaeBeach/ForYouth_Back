package com.haebeach.foryouth.realty.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haebeach.foryouth.realty.dto.ShNoticeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CrawlerService {

    @Value("${crawler.webProtocol}")
    private String webProtocol;

    @Value("${crawler.host}")
    private String host;

    @Value("${crawler.port}")
    private String port;

    @Value("${crawler.shNoticePath}")
    private String path;

    private ShNoticeDto shNoticeDto;

    @Async
    public CompletableFuture<String> requestSHCrawler() {
        String result = "false";
        StringBuilder urlBuilder = new StringBuilder(webProtocol + "://" + host + ":" + port + "/" + path);

        try {
            log.info("Requested url : " + urlBuilder.toString());
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            log.info("Response code : " + conn.getResponseCode());

            BufferedReader rd;
            StringBuilder sb = new StringBuilder();
            String line;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            Gson gson = new Gson();
            this.shNoticeDto = gson.fromJson(sb.toString(), new TypeToken<ShNoticeDto>(){}.getType());
            if ("S".equals(this.shNoticeDto.getResultCd())) {
                result = "true";
            }
            else {
                log.error("error : " + this.shNoticeDto.getErrMsg());
            }
        }
        catch (IOException e) {
            log.error("error : {}", e);
            Thread.currentThread().interrupt();
        }

        return CompletableFuture.completedFuture(result);
    }

}
