package com.CareerBridge.CareerBridge.service;

import com.CareerBridge.CareerBridge.dto.user.AuthResponse;
import com.CareerBridge.CareerBridge.dto.user.LoginRequest;
import com.CareerBridge.CareerBridge.dto.user.RegisterRequest;
import com.CareerBridge.CareerBridge.dto.user.UserResponse;
import com.CareerBridge.CareerBridge.repository.UserRepository;
import org.jspecify.annotations.Nullable;

public interface UserService{
    UserResponse registerUser(RegisterRequest request);
    AuthResponse loginUser(LoginRequest request);

     UserResponse findById(Long userId);
}
