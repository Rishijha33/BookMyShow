package services;

import exceptions.UserNotPresent;
import models.User;
import repositories.UserRepository;

import javax.management.RuntimeMBeanException;
import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) throws UserNotPresent {
        Optional<User> optionalUser = userRepository.findByEmailId(email);

        if (optionalUser.isEmpty())
        {
            throw new UserNotPresent("User not registered");
        }

        User user = optionalUser.get();

        String userPassword = user.getPassword();
        if (password.equals(userPassword))
        {
            return user;
        }

        throw new RuntimeException("Wrong password");




    }
}
