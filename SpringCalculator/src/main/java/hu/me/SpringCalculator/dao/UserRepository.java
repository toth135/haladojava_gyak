package hu.me.SpringCalculator.dao;

import hu.me.SpringCalculator.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findByUsername(String username);
}
