package org.pragma.foodcourtusers.util;

public enum MessageTestEnum{


    ID_USER_EQUAL("Los ids de los usuarios son iguales"),

    NAME_USER_EQUAL("Los nombres de los usuarios son iguales"),

    LASTNAME_USER_EQUAL("Los apellidos de los usuarios son iguales"),

    DOCUMENT_ID_USER_EQUAL("Los numeros de documento de los usuarios son iguales"),

    CELL_PHONE_NUMBER_USER_EQUAL("Los numeros de celular de los usuarios son iguales"),

    BIRTH_DATE_USER_EQUAL("Las fechas de cumpleaños de los usuarios son iguales"),

    EMAIL_USER_EQUAL("Los correos electronicos de los usuarios son iguales"),

    PASSWORD_USER_EQUAL("Las contraseñas de los usuarios son iguales"),

    ROLE_ID_USER_EQUAL("Los id del role de los usuarios son iguales"),

    ID_ROLE_EQUAL("Los ids del los roles son iguales"),

    NAME_ROLE_EQUAL("Los nombres de los roles son iguales"),

    DESCRIPTION_ROLE_EQUAL("Las descripciones de los roles son iguales");


    private String message;

    private MessageTestEnum (String message){
        this.message = message;
    }

    public String getMessage (){
        return this.message;
    }


}
