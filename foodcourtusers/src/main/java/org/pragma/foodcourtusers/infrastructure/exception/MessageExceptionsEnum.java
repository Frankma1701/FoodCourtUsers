package org.pragma.foodcourtusers.infrastructure.exception;

public enum MessageExceptionsEnum{

   USER_ALREADY_EXIST("El usuario con el documento validado ya existe"),
    USER_NOT_FOUND("El usuario con el id validado no se encuentra registrado"),

   ROLE_NOT_FOUND_EXCEPTION("El rol con el id validado no se encuentra registrado");


    private String message;

    private MessageExceptionsEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }


}
