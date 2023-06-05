package com.haebeach.foryouth.realty.config;

import com.haebeach.foryouth.realty.batch.LhNoticeReader;
import com.haebeach.foryouth.realty.batch.LhNoticeWriter;
import com.haebeach.foryouth.realty.dto.LhNoticeResDto;
import com.haebeach.foryouth.realty.entity.LhNoticeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class LhNoticeBatchJobConfig {

    private final LhNoticeReader lhNoticeReader;
    private final LhNoticeWriter lhNoticeWriter;

    @Bean
    public Job LhNoticeBatchJob(JobRepository jobRepository, Step LhNoticeBatchStep) {
        return new JobBuilder("LhNoticeBatchJob", jobRepository)
                .start(LhNoticeBatchStep)
                .build();
    }

    @Bean
    public Step LhNoticeBatchStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("LhNoticeBatchStep", jobRepository)
                .<LhNoticeResDto, LhNoticeRes>chunk(1000, platformTransactionManager)
                .reader(lhNoticeReader)
                .processor(processor())
                .writer(lhNoticeWriter)
                .build();
    }

    @Bean
    public ItemProcessor<LhNoticeResDto, LhNoticeRes> processor() {
        return LhNoticeResDto -> LhNoticeRes.builder()
                .seq(LhNoticeResDto.getSeq())
                .linkUrl(LhNoticeResDto.getLinkUrl())
                .page(LhNoticeResDto.getPage())
                .rnum(Integer.parseInt(LhNoticeResDto.getRnum()))
                .bbsWouDttm(LhNoticeResDto.getBbsWouDttm())
                .allCnt(LhNoticeResDto.getAllCnt())
                .bbsSn(LhNoticeResDto.getBbsSn())
                .bbsTl(LhNoticeResDto.getBbsTl())
                .inqCnt(LhNoticeResDto.getInqCnt())
                .aisTpCdNm(LhNoticeResDto.getAisTpCdNm())
                .ccrCnntSysDsCd(LhNoticeResDto.getCcrCnntSysDsCd())
                .depNm(LhNoticeResDto.getDepNm())
                .build();
    }

}
