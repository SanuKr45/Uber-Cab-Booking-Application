package com.coding.project.uber.uberApp.services;

import com.coding.project.uber.uberApp.dto.DriverDto;
import com.coding.project.uber.uberApp.dto.SignUpDto;
import com.coding.project.uber.uberApp.dto.UserDto;

public interface AuthService {
    String[] login(String email, String password);

    UserDto signUp(SignUpDto signUpDto);

    DriverDto onBoardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);

}
