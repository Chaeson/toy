package kr.co.toy.batch.config;

import kr.co.toy.batch.domain.Coffee;
import kr.co.toy.batch.listener.JobCompletionNotificationListener;
import kr.co.toy.batch.process.CoffeeItemProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Date;

@Slf4j
//@Configuration
//@EnableBatchProcessing
public class ScheduleJob {

//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job job;
//
//
//    @Scheduled(cron = "*/5 * * * * *")
//    public void perform() throws Exception {
//
//        System.out.println("Job Started at :" + new Date());
//
//        JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        log.info("JOB LIST: {}", job.getName());
//        if(job.getName().equals("importUserJob"))
//            jobLauncher.run(job, param);
//    }
}
