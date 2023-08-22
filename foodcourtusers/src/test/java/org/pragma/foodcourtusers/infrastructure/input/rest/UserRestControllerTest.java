package org.pragma.foodcourtusers.infrastructure.input.rest;


import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.handler.UserHandler;
import org.pragma.foodcourtusers.application.mapper.request.UserRequestMapper;
import org.pragma.foodcourtusers.application.mapper.response.UserResponseMapper;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.infrastructure.security.JwtService;
import org.pragma.foodcourtusers.util.FactoryUser;
import org.pragma.foodcourtusers.util.FactoryUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class UserRestControllerTest{

    @Mock
    private UserHandler userHandler;

    @InjectMocks
    private UserRestController userRestController;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetUser() {
        String documentId = FactoryUser.DOCUMENT_ID_USER_TO_ASK;
        UserResponse expectedResponse = FactoryUserResponse.expectedObject;
        when(userHandler.getUser(documentId)).thenReturn(expectedResponse);
        ResponseEntity<UserResponse> responseEntity = userRestController.getUser(documentId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
        verify(userHandler, times(1)).getUser(documentId);
        verifyNoMoreInteractions(userHandler);
    }

    @Test
    public void testGetUserById() {
        Long userId = FactoryUser.ID_USER_TO_ASK;
        UserResponse expectedResponse = FactoryUserResponse.expectedObject;
        when(userHandler.getUserById(userId)).thenReturn(expectedResponse);
        ResponseEntity<UserResponse> responseEntity = userRestController.getUserById(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
        verify(userHandler, times(1)).getUserById(userId);
        verifyNoMoreInteractions(userHandler);
    }


}