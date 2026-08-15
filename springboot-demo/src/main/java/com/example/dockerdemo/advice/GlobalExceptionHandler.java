package com.example.dockerdemo.advice;

import com.example.dockerdemo.exception.StudentNotFoundException;
import com.example.dockerdemo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            StudentNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(build(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(build(
                        HttpStatus.BAD_REQUEST,
                        message));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generic(
            Exception ex) {

        return ResponseEntity.internalServerError()
                .body(build(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage()));
    }

    private ErrorResponse build(
            HttpStatus status,
            String message) {

        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .build();
    }

}