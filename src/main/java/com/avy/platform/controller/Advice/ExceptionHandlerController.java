package com.avy.platform.controller.Advice;

import com.avy.platform.DTO.ErrorResponseDTO;
import com.avy.platform.exception.DefaultHandlerExceptionCustom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    List<HttpStatus> code = new ArrayList<>(Arrays.asList(HttpStatus.BAD_REQUEST));

    @ExceptionHandler(DefaultHandlerExceptionCustom.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(DefaultHandlerExceptionCustom e, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMethod(request.getMethod());
        return ResponseEntity.status(code.get(2)).body(errorResponse);
    }

}
