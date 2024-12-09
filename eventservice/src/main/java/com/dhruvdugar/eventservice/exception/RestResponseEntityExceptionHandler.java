package com.dhruvdugar.eventservice.exception;

import com.dhruvdugar.eventservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(CustomException ex){
////        new ErrorResponse();
//        return new ResponseEntity<>(
//                ErrorResponse.builder()
//                        .message(ex.getMessage())
//                        .code(ex.getStatus())
//                        .build(), HttpStatus.NOT_FOUND);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setErrorCode(String.valueOf(ex.getStatus()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
