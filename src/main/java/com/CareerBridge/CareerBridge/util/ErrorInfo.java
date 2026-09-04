package com.CareerBridge.CareerBridge.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class ErrorInfo {
    private String codeTye;
    private Integer code;
    private LocalDateTime timeStamp;
    private String message;
}
