package kr.co.toy.batch.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/** Spring Batch Docs의 예제 Instance **/
@Data
@Entity
public class Coffee {

    @Id
    private int seq;

    private String brand;
    private String origin;
    private String characteristics;

    // 기본 생성자.
    public Coffee(){}

    @Builder
    public Coffee(int seq, String brand, String origin, String characteristics){
        this.seq = seq;
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }
}
