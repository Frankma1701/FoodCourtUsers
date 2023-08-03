package org.pragma.usersfoodcourt.infrastructure.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LegalAgeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LegalAge{
    String message() default "El usuario ingresado no es mayor de edad ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}