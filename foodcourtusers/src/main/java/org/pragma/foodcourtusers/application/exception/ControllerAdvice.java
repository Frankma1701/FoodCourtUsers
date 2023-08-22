package org.pragma.foodcourtusers.application.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ErrorInfo> runtimeExceptionHandler (CustomException ex){
        ErrorInfo error = ErrorInfo.builder().code(ex.getErrorCode()).message(ex.getMessage()).build();
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorInfo> handleMethodArgumentNotValid(ConstraintViolationException exception) {
        List<String> exceptionalErrors = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessageTemplate)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        ErrorInfo error = ErrorInfo.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message(String.join(", ",exceptionalErrors)).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
