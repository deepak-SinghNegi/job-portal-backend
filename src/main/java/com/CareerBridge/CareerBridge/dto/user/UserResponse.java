package com.CareerBridge.CareerBridge.dto.user;

import com.CareerBridge.CareerBridge.dto.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private AccountType accountType;
    private LocalDateTime createdAt;
}
