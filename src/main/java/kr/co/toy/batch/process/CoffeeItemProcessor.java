package kr.co.toy.batch.process;

import kr.co.toy.batch.domain.Coffee;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;

@Slf4j
public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee> {

    // 실제 Batch의 비즈니스 로직이다.
    @Override
    public Coffee process(Coffee coffee) throws Exception {
        String brand = coffee.getBrand();
        String origin = coffee.getOrigin()+ LocalDateTime.now().getDayOfYear();
        String characteristics = coffee.getCharacteristics().toUpperCase();
        int seq = coffee.getSeq();

        Coffee transformedCoffee = Coffee.builder().brand(brand)
                .origin(origin)
                .characteristics(characteristics)
                .seq(seq)
                .build();
        log.info("Converting ({}) into ({})", coffee, transformedCoffee);
        return transformedCoffee;
    }
}
