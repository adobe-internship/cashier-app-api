package com.demo.cashierapp.exception.types;

public class UsernameExistsCustomException extends ApiRequestException{
    public UsernameExistsCustomException(String message) {
        super(message);
    }

    public UsernameExistsCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
