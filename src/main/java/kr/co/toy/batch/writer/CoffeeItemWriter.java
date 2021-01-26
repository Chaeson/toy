package kr.co.toy.batch.writer;

import kr.co.toy.batch.domain.Coffee;
import kr.co.toy.batch.domain.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class CoffeeItemWriter implements ItemWriter<Coffee> {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public void write(List<? extends Coffee> items) throws Exception {
        for (Coffee item : items){
            log.info("update Item: {}", item);
        }
        coffeeRepository.saveAll(items);
    }
}
