package org.pragma.foodcourtusers.infrastructure.exception;

import org.pragma.foodcourtusers.infrastructure.util.ExceptionConstant;
import org.springframework.core.Constants;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException() {
        super(ExceptionConstant.USER_ALREADY_EXIST);
    }
}
