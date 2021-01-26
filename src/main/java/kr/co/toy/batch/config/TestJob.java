package kr.co.toy.batch.config;

import kr.co.toy.batch.domain.Coffee;
import kr.co.toy.batch.domain.repository.CoffeeRepository;
import kr.co.toy.batch.process.CoffeeItemProcessor;
import kr.co.toy.batch.reader.CoffeeItemReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class TestJob {

    /** Batch 기본 **/
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${file.input}")
    private String fileInput;

    @Autowired
    public CoffeeRepository coffeeRepository;

    // 데이터를 읽는 Batch Reader
    // > file.input 프로퍼티의 데이터를 읽는다.
    @Bean
    public CoffeeItemReader<Coffee> reader(){
        List<Coffee> coffeeList = coffeeRepository.findAllByOrigin("Jamaica2525");
        return new CoffeeItemReader<>(coffeeList);
    }

    @Bean
    public ItemWriter<Coffee> writer(){
        return ((List<? extends Coffee> coffees) ->
                coffeeRepository.saveAll(coffees));
    }

    @Bean
    public Job importUserJob(){
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end().build();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<Coffee, Coffee> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public CoffeeItemProcessor processor(){
        return new CoffeeItemProcessor();
    }

}
