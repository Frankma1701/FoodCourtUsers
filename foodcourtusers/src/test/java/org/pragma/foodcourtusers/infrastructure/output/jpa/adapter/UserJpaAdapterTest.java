package org.pragma.foodcourtusers.infrastructure.output.jpa.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.infrastructure.exception.UserAlreadyExistException;
import org.pragma.foodcourtusers.infrastructure.exception.UserNotFoundException;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.UserEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.foodcourtusers.util.FactoryUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserJpaAdapterTest{

    @Mock
    private IUserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @InjectMocks
    private UserJpaAdapter userJpaAdapter;


    @Test
    public void saveUserSuccess() {
        User user = FactoryUser.mockObject;
        UserEntity userEntity = new UserEntity();
        when(userRepository.findByDocumentId(user.getDocumentId())).thenReturn(Optional.empty());
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userJpaAdapter.saveUser(user)).thenReturn(user);
        User savedUser = userJpaAdapter.saveUser(user);
        assertNotNull(savedUser);
    }

    @Test
    public void saveUserAlreadyExist() {
        User user = FactoryUser.mockObject;
        when(userRepository.findByDocumentId(user.getDocumentId())).thenReturn(Optional.of(new UserEntity()));
        assertThrows(UserAlreadyExistException.class, () -> userJpaAdapter.saveUser(user));
        verify(userRepository, times(1)).findByDocumentId(user.getDocumentId());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void getUser() {
        String documentId = FactoryUser.DOCUMENT_ID_USER_TO_ASK;
        UserEntity userEntity = new UserEntity();
        User user = FactoryUser.mockObject;
        when(userRepository.findByDocumentId(documentId)).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);
        User retrievedUser = userJpaAdapter.getUser(documentId);
        assertNotNull(retrievedUser);
        verify(userRepository, times(1)).findByDocumentId(documentId);
    }

    @Test
    public void getUserUserNofFound() {
        String documentId = FactoryUser.DOCUMENT_ID_USER_TO_ASK;
        when(userRepository.findByDocumentId(documentId)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userJpaAdapter.getUser(documentId));
        verify(userRepository, times(1)).findByDocumentId(documentId);
    }

    @Test
    public void getUserById() {
        Long userId= FactoryUser.ID_USER_TO_ASK;
        UserEntity userEntity = new UserEntity();
        User user = FactoryUser.mockObject;
        when(userRepository.getReferenceById(userId)).thenReturn(userEntity);
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);
        User retrievedUser = userJpaAdapter.getUserById(userId);
        assertNotNull(retrievedUser);
        verify(userRepository, times(1)).getReferenceById(userId);
    }


}