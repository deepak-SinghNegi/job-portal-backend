package com.CareerBridge.CareerBridge.controller;

import com.CareerBridge.CareerBridge.dto.user.RegisterRequest;
import com.CareerBridge.CareerBridge.dto.user.UserResponse;
import com.CareerBridge.CareerBridge.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrUser(Authentication authentication){
        Long userId = (Long)authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findById(userId));
    }

}
