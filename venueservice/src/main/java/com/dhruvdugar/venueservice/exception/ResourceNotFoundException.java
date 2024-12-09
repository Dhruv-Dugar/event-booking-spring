package com.dhruvdugar.venueservice.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldVaue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldVaue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldVaue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldVaue = fieldVaue;
    }
}
