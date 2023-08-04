package org.pragma.usersfoodcourt.infrastructure.exception;

import org.pragma.usersfoodcourt.infrastructure.util.ExceptionConstant;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super(ExceptionConstant.USER_NOT_FOUND);
    }
}
