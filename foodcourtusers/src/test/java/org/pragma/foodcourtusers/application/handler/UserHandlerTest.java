package org.pragma.foodcourtusers.application.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.mapper.request.UserRequestMapper;
import org.pragma.foodcourtusers.application.mapper.response.UserResponseMapper;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.infrastructure.exception.UserNotFoundException;
import org.pragma.foodcourtusers.util.*;
import org.pragma.foodcourtusers.domain.api.IRoleServicePort;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest{

    @Mock
    private IUserServicePort iUserServicePort;

    @Mock
    private IRoleServicePort iRoleServicePort;

    @Mock
    private UserRequestMapper userRequestMapper;

    @Mock
    private UserResponseMapper userResponseMapper;

    @InjectMocks
    private UserHandler userHandler;

    @BeforeEach
    void setUp (){
    }
    @Test
    void saveUser (){
        UserRequest userRequest = FactoryUserRequest.mockObject;
        User user = FactoryUser.expectedObject;
        when(userRequestMapper.toUser(any())).thenReturn(user);
        when(iUserServicePort.saveUser(any())).thenReturn(user);
        User resultObject = userHandler.saveUser(userRequest);
        assertEquals(FactoryUser.expectedObject.getId(),resultObject.getId(), ConstantsTests.ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getName(),resultObject.getName(), ConstantsTests.NAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getLastName(),resultObject.getLastName(), ConstantsTests.LASTNAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getDocumentId(),resultObject.getDocumentId(), ConstantsTests.DOCUMENT_ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), ConstantsTests.CELL_PHONE_NUMBER_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getBirthDate(),resultObject.getBirthDate(), ConstantsTests.BIRTH_DATE_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getEmail(),resultObject.getEmail(), ConstantsTests.EMAIL_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getPassword(),resultObject.getPassword(), ConstantsTests.PASSWORD_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getRoleId(),resultObject.getRoleId(), ConstantsTests.ROLE_ID_USER_EQUAL);
        verify(iUserServicePort).saveUser(user);
    }
    @Test
    void getUser (){
        String documentId = ConstantsTests.DOCUMENT_ID_USER_TO_ASK;
        User user = FactoryUser.mockObject;
        UserResponse userResponse = FactoryUserResponse.mockObject;
        when(iUserServicePort.getUser(documentId)).thenReturn(user);
        when(userResponseMapper.toResponse(any())).thenReturn(userResponse);
        UserResponse resultObject = userHandler.getUser(documentId);
        assertEquals(FactoryUserResponse.expectedObject.getId(),resultObject.getId(), ConstantsTests.ID_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getName(),resultObject.getName(), ConstantsTests.NAME_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getLastName(),resultObject.getLastName(), ConstantsTests.LASTNAME_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getDocumentId(),resultObject.getDocumentId(), ConstantsTests.DOCUMENT_ID_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), ConstantsTests.CELL_PHONE_NUMBER_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getBirthDate(),resultObject.getBirthDate(), ConstantsTests.BIRTH_DATE_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getEmail(),resultObject.getEmail(), ConstantsTests.EMAIL_USER_EQUAL);
        assertEquals(FactoryUserResponse.expectedObject.getRoleId(),resultObject.getRoleId(), ConstantsTests.ROLE_ID_USER_EQUAL);
        verify(iUserServicePort, times(1)).getUser(documentId);
        verify(userResponseMapper, times(1)).toResponse(any());

       }
}