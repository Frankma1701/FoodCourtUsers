package org.pragma.foodcourtusers.util;


import org.pragma.foodcourtusers.application.exception.CustomException;

public class FactoryCustomException{

    public static final CustomException customException = new CustomException("Error en los datos","400");

    public static final String messageValidationException = "Error en la validación , ingresa correctamente el dato";

}
