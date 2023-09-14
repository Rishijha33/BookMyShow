package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    //JPARepository


    @Override
    Optional<User> findById(Long aLong);
    //find the user by the given userId
}
