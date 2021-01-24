package kr.co.toy.batch.domain;

import lombok.Builder;
import lombok.Data;

/** Spring Batch Docs의 예제 Instance **/
@Data
public class Coffee {

    private String brand;
    private String origin;
    private String characteristics;

    // 기본 생성자.
    public Coffee(){}

    @Builder
    public Coffee(String brand, String origin, String characteristics){
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }
}
