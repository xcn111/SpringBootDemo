package com.example.demo.handler;

import com.example.demo.Pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionhandler(RuntimeException ex) {
        return Result.error(ex.getMessage());
    }
}