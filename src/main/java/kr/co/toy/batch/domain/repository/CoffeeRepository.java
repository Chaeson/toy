package kr.co.toy.batch.domain.repository;

import kr.co.toy.batch.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findAllByOrigin(String origin);
}
