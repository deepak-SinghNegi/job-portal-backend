package com.CareerBridge.CareerBridge.exception;

import com.CareerBridge.CareerBridge.util.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorInfo> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException error){
        Map<String , String> map = new HashMap<>();
        error.getBindingResult().getFieldErrors().forEach(er ->{
            map.put(er.getField() , er.getDefaultMessage());
        });
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            if(!isFirst)sb.append(" , ");
            isFirst = false;
            sb.append(key +" : "+ map.get(key));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(
                "BAD_REQUEST",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                sb.toString()
        ));
    }

    @ExceptionHandler(InvalidEmailOrPasswordException.class)
    public ResponseEntity<ErrorInfo> InvalidEmailOrPasswordExceptionHandler (InvalidEmailOrPasswordException error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(
                "BAD_REQUEST",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                error.getMessage()
        ));

    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorInfo> UserAlreadyExistExceptionHandler(UserAlreadyExistException error){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorInfo(
                "UNAUTHORIZED",
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now(),
                error.getMessage()
        ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorInfo> UseNotFoundExceptionHandler(UserNotFoundException error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorInfo(
                "NOT_FOUND",
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                error.getMessage()
        ));
    }
}
