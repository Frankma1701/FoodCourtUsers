package org.pragma.foodcourtusers.application.dto.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRequestTest{

    @Test
    public void testGetters() {
        String email = "test@example.com";
        String password = "password";
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(email, password);
        assertEquals(email, authenticationRequest.getEmail());
        assertEquals(password, authenticationRequest.getPassword());
    }

}