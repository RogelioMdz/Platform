package com.avy.platform.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConstraintViolationExceptionCustom extends RuntimeException{
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private String method;
    public ConstraintViolationExceptionCustom(String message) {
        super(message);
        this.message = message;
    }

    public ConstraintViolationExceptionCustom(String message, String path, LocalDateTime timestamp, String method) {
        super(message);
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
        this.method = method;
    }
}
