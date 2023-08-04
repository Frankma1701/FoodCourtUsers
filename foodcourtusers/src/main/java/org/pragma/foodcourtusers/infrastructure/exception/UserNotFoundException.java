package org.pragma.foodcourtusers.infrastructure.exception;

import org.pragma.foodcourtusers.infrastructure.util.ExceptionConstant;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super(ExceptionConstant.USER_NOT_FOUND);
    }
}
