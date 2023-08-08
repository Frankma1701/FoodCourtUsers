package org.pragma.foodcourtusers.infrastructure.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException() {
        super(ExceptionConstant.USER_ALREADY_EXIST);
    }
}
