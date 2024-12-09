package com.dhruvdugar.venueservice.exception;

import com.dhruvdugar.venueservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
        String message = e.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, message);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> noSuchElementExceptionHandler(NoSuchElementException ex){
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, message);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> customExceptionHandler(Exception ex){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(
                        status,
                        ex.getMessage(),
                        stackTrace
                ),
                status
        );
    }
}
