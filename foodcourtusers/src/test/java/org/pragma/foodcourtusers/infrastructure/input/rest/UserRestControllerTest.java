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


class UserRestControllerTest{

    @Test
    public void testGetUser() {
        UserHandler userHandler = mock(UserHandler.class);
        String documentId = "user123";
        UserResponse userResponse = FactoryUserResponse.mockObject;
        when(userHandler.getUser(documentId)).thenReturn(userResponse);
        UserRestController userRestController = new UserRestController(userHandler);
        ResponseEntity<UserResponse> response = userRestController.getUser(documentId);
        verify(userHandler).getUser(documentId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
    }


}