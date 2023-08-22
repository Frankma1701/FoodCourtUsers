package org.pragma.foodcourtusers.application.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class ErrorInfo {
    private String code;
    private String message;


}