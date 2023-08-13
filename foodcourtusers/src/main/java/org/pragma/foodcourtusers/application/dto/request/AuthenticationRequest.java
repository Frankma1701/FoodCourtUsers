package org.pragma.foodcourtusers.application.dto.request;

import lombok.*;

@AllArgsConstructor
@Getter
public class AuthenticationRequest{
    private String email;
    private String password;
}
