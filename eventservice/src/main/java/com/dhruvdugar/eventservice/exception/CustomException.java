package com.dhruvdugar.eventservice.exception;

public class CustomException extends RuntimeException {
    private int errorCode;
    private int status;

    public CustomException(String message, int errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public CustomException(String message, int status){
        super(message);
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "errorCode=" + errorCode +
                ", status=" + status +
                '}';
    }
}
