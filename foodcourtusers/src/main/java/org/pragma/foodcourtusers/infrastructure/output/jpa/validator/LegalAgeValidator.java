package org.pragma.foodcourtusers.infrastructure.output.jpa.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LegalAgeValidator implements ConstraintValidator<LegalAge, LocalDate>{
    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        LocalDate actualDate = LocalDate.now();
        int age = actualDate.getYear()-birthDate.getYear();
        if ((birthDate.getMonth().getValue() >= actualDate.getMonth().getValue())
                && (birthDate.getDayOfMonth() > actualDate.getDayOfMonth())) {
            age--;
        }
        return age >= 18;
    }
}