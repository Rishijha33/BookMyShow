package repositories;

import models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface UserRepository extends JpaRepository <User, Long> {
    //JPARepository


    @Override
    Optional<User> findById(Long aLong);
    //find the user by the given userId



    Optional<User> findByEmailId (String email);
}
