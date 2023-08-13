package org.pragma.foodcourtusers.infrastructure.input.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pragma.foodcourtusers.application.dto.request.AuthenticationRequest;
import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.JwtResponse;
import org.pragma.foodcourtusers.infrastructure.security.AuthenticationHandler;
import org.pragma.foodcourtusers.infrastructure.util.Roles;
import org.pragma.foodcourtusers.util.FactoryOwnerRequest;
import org.pragma.foodcourtusers.util.FactoryUserRequest;
import org.pragma.foodcourtusers.util.FactoryUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationRestControllerTest{

    @BeforeEach
    void setUp (){
    }

    @Test
    public void testSave() {
        AuthenticationHandler authenticationHandler = mock(AuthenticationHandler.class);
        UserRequest userRequest = FactoryUserRequest.mockObject;
        JwtResponse jwtResponse = new JwtResponse("token");
        when(authenticationHandler.register(userRequest)).thenReturn(jwtResponse);
        AuthenticationRestController authRestController = new AuthenticationRestController(authenticationHandler);
        ResponseEntity<JwtResponse> response = authRestController.save(userRequest);
        verify(authenticationHandler).register(userRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jwtResponse, response.getBody());
    }

    @Test
    public void testSaveOwner() {
        AuthenticationHandler authenticationHandler = mock(AuthenticationHandler.class);
        OwnerRequest ownerRequest = FactoryOwnerRequest.mockObject;
        JwtResponse jwtResponse = new JwtResponse("token");
        when(authenticationHandler.registerUser(ownerRequest, Roles.OWNER.getId())).thenReturn(jwtResponse);
        AuthenticationRestController authRestController = new AuthenticationRestController(authenticationHandler);
        ResponseEntity<JwtResponse> response = authRestController.saveOwner(ownerRequest);
        verify(authenticationHandler).registerUser(ownerRequest, Roles.OWNER.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jwtResponse, response.getBody());
    }

    @Test
    public void testSaveCustomer() {
        AuthenticationHandler authenticationHandler = mock(AuthenticationHandler.class);
        OwnerRequest ownerRequest = FactoryOwnerRequest.mockObject;
        JwtResponse jwtResponse = new JwtResponse("token");
        when(authenticationHandler.registerUser(ownerRequest, Roles.CUSTOMER.getId())).thenReturn(jwtResponse);
        AuthenticationRestController authRestController = new AuthenticationRestController(authenticationHandler);
        ResponseEntity<JwtResponse> response = authRestController.saveCustomer(ownerRequest);
        verify(authenticationHandler).registerUser(ownerRequest, Roles.CUSTOMER.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jwtResponse, response.getBody());
    }

    @Test
    void testSaveEmployee (){
        AuthenticationHandler authenticationHandler = mock(AuthenticationHandler.class);
        OwnerRequest ownerRequest = FactoryOwnerRequest.mockObject;
        JwtResponse jwtResponse = new JwtResponse("token");
        when(authenticationHandler.registerUser(ownerRequest, Roles.EMPLOYEE.getId())).thenReturn(jwtResponse);
        AuthenticationRestController authRestController = new AuthenticationRestController(authenticationHandler);
        ResponseEntity<JwtResponse> response = authRestController.saveEmployee(ownerRequest);
        verify(authenticationHandler).registerUser(ownerRequest, Roles.EMPLOYEE.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jwtResponse, response.getBody());
    }

    @Test
    void signIn (){
        AuthenticationHandler authenticationHandler = mock(AuthenticationHandler.class);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("username", "password");
        JwtResponse jwtResponse = new JwtResponse("token");
        when(authenticationHandler.signIn(authenticationRequest)).thenReturn(jwtResponse);
        AuthenticationRestController authRestController = new AuthenticationRestController(authenticationHandler);
        ResponseEntity<JwtResponse> response = authRestController.signIn(authenticationRequest);
        verify(authenticationHandler).signIn(authenticationRequest);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(jwtResponse, response.getBody());
    }
}