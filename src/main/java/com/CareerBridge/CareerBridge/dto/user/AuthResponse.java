package com.CareerBridge.CareerBridge.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private UserResponse userResponse;
}
