package kr.co.toy.batch.listener;

import kr.co.toy.batch.domain.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("JOB FINISHED!!");
            String query = "SELECT brand, origin, characteristics FROM coffee";
            jdbcTemplate.query(query,(rs,row) -> Coffee.builder()
                            .brand(rs.getString(1))
                            .origin(rs.getString(2))
                            .characteristics(rs.getString(3)))
                    .forEach( coffee -> log.info("Found < {} > in the database.",coffee));
        }
    }
}
