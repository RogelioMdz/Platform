package com.avy.platform.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDTO {

    @JsonProperty("message")
    private String message;
    @JsonProperty("path")
    private String path;
    @JsonProperty("time-stap")
    private LocalDateTime timestamp;
    @JsonProperty("method")
    private String method;
}