package org.pragma.foodcourtusers.infrastructure.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {
    private String code;
    private String message;


}