package com.avy.platform.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultHandlerExceptionCustom extends RuntimeException{
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private String method;
    public DefaultHandlerExceptionCustom(String message) {
        super(message);
        this.message = message;
    }

    public DefaultHandlerExceptionCustom(String message, String path, LocalDateTime timestamp, String method) {
        super(message);
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
        this.method = method;
    }
}
