package com.avy.platform.controller.Advice;

import com.avy.platform.DTO.ErrorResponseDTO;
import com.avy.platform.exception.ConstraintViolationExceptionCustom;
import com.avy.platform.exception.DefaultHandlerExceptionCustom;
import com.avy.platform.exception.SQLIntegrityConstraintViolationExceptionCustom;
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

    List<HttpStatus> code = new ArrayList<>(Arrays.asList(HttpStatus.BAD_REQUEST, HttpStatus.INTERNAL_SERVER_ERROR));

    @ExceptionHandler(DefaultHandlerExceptionCustom.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(DefaultHandlerExceptionCustom e, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMethod(request.getMethod());
        return ResponseEntity.status(code.get(0)).body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationExceptionCustom.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(ConstraintViolationExceptionCustom e, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMethod(request.getMethod());
        return ResponseEntity.status(code.get(1)).body(errorResponse);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationExceptionCustom.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(SQLIntegrityConstraintViolationExceptionCustom e, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setMethod(request.getMethod());
        return ResponseEntity.status(code.get(1)).body(errorResponse);
    }


}
