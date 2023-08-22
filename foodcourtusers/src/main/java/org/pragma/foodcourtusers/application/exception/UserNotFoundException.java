package org.pragma.foodcourtusers.application.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException{

    public UserNotFoundException() {
        super(String.valueOf(HttpStatus.NOT_FOUND.value()),MessageExceptionsEnum.USER_NOT_FOUND.getMessage());
    }
}
