package com.haebeach.foryouth.realty.batch;

import com.haebeach.foryouth.realty.entity.LhNoticeRes;
import com.haebeach.foryouth.realty.repository.LhNoticeResRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class LhNoticeWriter implements ItemWriter<LhNoticeRes> {

    private final LhNoticeResRepository lhNoticeResRepository;

    @Override
    public void write(Chunk<? extends LhNoticeRes> chunk) throws Exception {
        lhNoticeResRepository.saveAll(new ArrayList<LhNoticeRes>(chunk.getItems()));
    }
}
