package org.pragma.foodcourtusers.infrastructure.exception;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException() {
        super(ExceptionConstant.ROLE_NOT_FOUND_EXCEPTION);;
    }
}
