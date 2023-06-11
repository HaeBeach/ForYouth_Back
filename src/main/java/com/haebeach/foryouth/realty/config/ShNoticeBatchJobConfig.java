package com.haebeach.foryouth.realty.config;

import com.haebeach.foryouth.realty.batch.ShNoticeTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ShNoticeBatchJobConfig {

    private final ShNoticeTasklet shNoticeTasklet;

    @Bean
    public Job shNoticeBatchJob(JobRepository jobRepository, Step shNoticeBatchStep) {
        return new JobBuilder("ShNoticeBatchJob", jobRepository)
                .start(shNoticeBatchStep)
                .build();
    }

    @Bean
    public Step shNoticeBatchStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("ShNoticeBatchStep", jobRepository)
                .tasklet(shNoticeTasklet, platformTransactionManager)
                .build();
    }

}
