package com.CareerBridge.CareerBridge.controller;

import com.CareerBridge.CareerBridge.dto.user.AuthResponse;
import com.CareerBridge.CareerBridge.dto.user.LoginRequest;
import com.CareerBridge.CareerBridge.dto.user.RegisterRequest;
import com.CareerBridge.CareerBridge.dto.user.UserResponse;
import com.CareerBridge.CareerBridge.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser (@Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser (@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.loginUser(loginRequest));
    }

}
