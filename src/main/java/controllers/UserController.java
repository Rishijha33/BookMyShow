package controllers;

import dtos.SignUpRequestDto;
import dtos.SignUpResponseDto;
import exceptions.UserNotPresent;
import models.ResponseStatus;
import models.User;
import services.UserService;

public class UserController {
    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) throws UserNotPresent {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.login(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpRequestDto.setEmail(user.getEmailId());
            signUpRequestDto.setPassword(user.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception exception)
        {
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDto;


    }

}
