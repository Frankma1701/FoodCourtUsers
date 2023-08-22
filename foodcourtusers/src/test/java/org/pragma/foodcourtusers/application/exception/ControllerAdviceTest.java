package org.pragma.foodcourtusers.application.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.util.FactoryCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerAdviceTest{

    @InjectMocks
    private ControllerAdvice controllerAdvice;

    @Mock
    private ConstraintViolationException mockException;

    @Mock
    private ConstraintViolation<?> mockViolation;
    @Test
    public void testCustomExceptionHandler() {
        CustomException customException = FactoryCustomException.customException;
        ResponseEntity<ErrorInfo> responseEntity = controllerAdvice.runtimeExceptionHandler(customException);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(customException.getErrorCode(), responseEntity.getBody().getCode());
        assertEquals(customException.getMessage(), responseEntity.getBody().getMessage());
    }

    @Test
    public void testConstraintViolationExceptionHandler() {
        String validationErrorMessage = FactoryCustomException.messageValidationException;
        when(mockException.getConstraintViolations()).thenReturn(
                Stream.of(mockViolation).collect(Collectors.toSet()));
        when(mockViolation.getMessageTemplate()).thenReturn(validationErrorMessage);
        ResponseEntity<ErrorInfo> responseEntity = controllerAdvice.handleMethodArgumentNotValid(mockException);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), responseEntity.getBody().getCode());
        assertEquals(validationErrorMessage, responseEntity.getBody().getMessage());
    }

}