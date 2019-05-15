package hu.me.SpringCalculator.dao;

import hu.me.SpringCalculator.entity.InputEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends CrudRepository<InputEntity, Long> {

}
