package org.pragma.foodcourtusers.infrastructure.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {
    private String code;
    private String message;


}