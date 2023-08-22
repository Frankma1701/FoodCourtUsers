package org.pragma.foodcourtusers.application.dto.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtResponseTest{

    @Test
    public void builderAndGetter() {
        String token = "token";
        JwtResponse jwtResponse = JwtResponse.builder()
                .token(token)
                .build();
        assertEquals(token, jwtResponse.getToken());
    }

}