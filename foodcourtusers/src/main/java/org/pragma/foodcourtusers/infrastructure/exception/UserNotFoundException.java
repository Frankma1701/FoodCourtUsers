package org.pragma.foodcourtusers.infrastructure.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super(ExceptionConstant.USER_NOT_FOUND);
    }
}
