package org.pragma.foodcourtusers.application.exception;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends CustomException{

    public RoleNotFoundException()  {
        super(String.valueOf(HttpStatus.NOT_FOUND.value()),MessageExceptionsEnum.ROLE_NOT_FOUND_EXCEPTION.getMessage());
    }
}
