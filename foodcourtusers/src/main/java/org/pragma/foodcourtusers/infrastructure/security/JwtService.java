package org.pragma.foodcourtusers.infrastructure.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService{


    public String extractUsername (String token){
        return "Ejemplo";
    }
}
