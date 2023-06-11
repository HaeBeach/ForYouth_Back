package com.haebeach.foryouth.realty.batch;

import com.haebeach.foryouth.realty.service.CrawlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
@JobScope
public class ShNoticeTasklet implements Tasklet, StepExecutionListener {

    private final CrawlerService crawlerService;

    @Override
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        log.info("before step");
    }

    @Override
    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("after step");
        return ExitStatus.COMPLETED;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("execute step");
        final CompletableFuture<String> crawlerResult = crawlerService.requestSHCrawler();
        crawlerResult.thenAccept(
                result -> {
                    if ("false".equals(result)) {
                        log.warn("request fail");
                        return ;
                    }
                    log.info("request success");
                }
        );
        return RepeatStatus.FINISHED;
    }

}
