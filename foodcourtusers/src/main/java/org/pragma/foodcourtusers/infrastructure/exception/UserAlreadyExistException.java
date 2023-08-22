package org.pragma.foodcourtusers.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends CustomException{

    public UserAlreadyExistException() {
        super(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                MessageExceptionsEnum.USER_ALREADY_EXIST.getMessage());
    }
}
