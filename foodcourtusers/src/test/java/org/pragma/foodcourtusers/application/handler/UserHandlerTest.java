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
import org.pragma.foodcourtusers.util.*;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest{

    @Mock
    private IUserServicePort iUserServicePort;
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
        assertEquals(FactoryUser.expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getPassword(),resultObject.getPassword(), MessageTestEnum.PASSWORD_USER_EQUAL.getMessage());
        assertEquals(FactoryUser.expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
        verify(iUserServicePort).saveUser(user);
    }
    @Test
    void getUser (){
        String documentId = FactoryUser.DOCUMENT_ID_USER_TO_ASK;
        User user = FactoryUser.mockObject;
        UserResponse userResponse = FactoryUserResponse.mockObject;
        when(iUserServicePort.getUser(documentId)).thenReturn(user);
        when(userResponseMapper.toResponse(any())).thenReturn(userResponse);
        UserResponse resultObject = userHandler.getUser(documentId);
        assertEquals(FactoryUserResponse.expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
        verify(iUserServicePort, times(1)).getUser(documentId);
        verify(userResponseMapper, times(1)).toResponse(any());

       }

    @Test
    void getUserById (){
        Long userId = FactoryUser.ID_USER_TO_ASK;
        User user = FactoryUser.mockObject;
        UserResponse userResponse = FactoryUserResponse.mockObject;
        when(iUserServicePort.getUserById(userId)).thenReturn(user);
        when(userResponseMapper.toResponse(any())).thenReturn(userResponse);
        UserResponse resultObject = userHandler.getUserById(userId);
        assertEquals(FactoryUserResponse.expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(FactoryUserResponse.expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
        verify(iUserServicePort, times(1)).getUserById(userId);
        verify(userResponseMapper, times(1)).toResponse(any());
    }
}