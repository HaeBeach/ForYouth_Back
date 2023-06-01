package com.haebeach.foryouth.realty.scheduler;

import com.haebeach.foryouth.realty.config.LhNoticeBatchJobConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobScheduler {

    private final JobLauncher jobLauncher;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final LhNoticeBatchJobConfig lhNoticeBatchJobConfig;

    @Scheduled(cron = "0 * * * * *")
    public void runLHJob() {
        log.info("========== Start LH notice batch job ==========");

        Map<String, JobParameter<?>> confMap = new HashMap<>();
        confMap.put("time", new JobParameter<>(System.currentTimeMillis(), Long.class));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            jobLauncher.run(lhNoticeBatchJobConfig.LhNoticeBatchJob(jobRepository, lhNoticeBatchJobConfig.LhNoticeBatchStep(jobRepository, platformTransactionManager)), jobParameters);
        } catch (JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        } catch (JobExecutionAlreadyRunningException e) {
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void runSH() {
        log.info("========== Start SH scheduler ==========");

        Map<String, JobParameter<?>> confMap = new HashMap<>();
        confMap.put("time", new JobParameter<>(System.currentTimeMillis(), Long.class));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            jobLauncher.run(lhNoticeBatchJobConfig.LhNoticeBatchJob(jobRepository, lhNoticeBatchJobConfig.LhNoticeBatchStep(jobRepository, platformTransactionManager)), jobParameters);
        } catch (JobInstanceAlreadyCompleteException e) {
            throw new RuntimeException(e);
        } catch (JobExecutionAlreadyRunningException e) {
            throw new RuntimeException(e);
        } catch (JobParametersInvalidException e) {
            throw new RuntimeException(e);
        } catch (JobRestartException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
