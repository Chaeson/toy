package kr.co.toy.batch.scheduler;

import kr.co.toy.batch.config.TestJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private TestJob testJob;

    // TestJob 은 5초 간격으로 실행!
    @Scheduled(cron = "*/5 * * * * *")
    public void runJob(){
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("time",new JobParameter((System.currentTimeMillis())));

        JobParameters jobParameters = new JobParameters(jobParameterMap);

        try {
            log.info("First Job");
            jobLauncher.run(testJob.importUserJob(), jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/7 * * * * *")
    public void secondJob(){
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("time",new JobParameter((System.currentTimeMillis())));

        JobParameters jobParameters = new JobParameters(jobParameterMap);

        try {
            log.info("Second Job");
            jobLauncher.run(testJob.importUserJob(), jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
