package com.dhruvdugar.eventservice.external.decoder;

import com.dhruvdugar.eventservice.exception.CustomException;
import com.dhruvdugar.venueservice.model.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
             return new CustomException(errorResponse.getMessage(), errorResponse.getCode(), response.status());
        } catch (IOException e) {
//            throw new RuntimeException(e);
            return  null;
        }
    }
}