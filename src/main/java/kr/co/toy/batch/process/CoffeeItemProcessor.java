package kr.co.toy.batch.process;

import kr.co.toy.batch.domain.Coffee;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee> {

    // 실제 Batch의 비즈니스 로직이다.
    @Override
    public Coffee process(Coffee coffee) throws Exception {
        String brand = coffee.getBrand();
        String origin = coffee.getOrigin();
        String characteristics = coffee.getCharacteristics().toUpperCase();

        Coffee transformedCoffee = new Coffee(brand, origin, characteristics);
        log.info("Converting ({}) into ({})", coffee, transformedCoffee);
        return transformedCoffee;
    }
}
