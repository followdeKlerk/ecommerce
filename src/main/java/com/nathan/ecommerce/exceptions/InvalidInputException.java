package com.nathan.ecommerce.exceptions;

public class InvalidInputException extends RuntimeException {

    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
