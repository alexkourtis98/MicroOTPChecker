package com.testdemo.Exceptions;

import com.testdemo.Models.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Global exception handler
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    // not readable json handler
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomError> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception
    ) {
        CustomError customError = buildCustomError(exception);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    // not good arguments/variables? missing some?
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        CustomError customError = buildCustomError(exception);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    // did not pass the otpservice dtopair check
    @ExceptionHandler(DisapprovedPairException.class)
    public ResponseEntity<CustomError> handleDisapprovedPairException(
            DisapprovedPairException exception
    ) {
        CustomError customError = buildCustomError(exception);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    // the dto pair is already tested against
    @ExceptionHandler(TestedAlreadyPairException.class)
    public ResponseEntity<CustomError> handleTestedAlreadyPairException(
            TestedAlreadyPairException exception
    ) {
        CustomError customError = buildCustomError(exception);
        return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
    }

    private CustomError buildCustomError(Exception runtimeException) {

        return new CustomError
                .Builder()
                .titleOfException(runtimeException.getClass().getSimpleName())
                .fullMessageOfException(runtimeException.getMessage())
                .datetimeOfException(new Date().toString())
                .httpStatusOfException(HttpStatus.BAD_REQUEST)
                .build();
    }
}