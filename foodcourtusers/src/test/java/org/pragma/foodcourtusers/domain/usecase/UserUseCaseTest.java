package org.pragma.usersfoodcourt.domain.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.domain.usecase.UserUseCase;
import org.pragma.foodcourtusers.infrastructure.output.jpa.adapter.UserJpaAdapter;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.UserEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest{

    @Mock
    private IUserPersistencePort iUserPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    private User mockObject;
    private User expectedObject;



    @BeforeEach
    void setUp(){
        mockObject = new User(1L,"Pedro","Perez", "14124",
                "431124", LocalDate.of(2001,04,13),
                "lopezpedro@hm.co", "pedroperez--",2L);;expectedObject = new User(1L,"Pedro","Perez", "14124",
                "431124", LocalDate.of(2001,04,13),
                "lopezpedro@hm.co", "pedroperez--",2L);;
    }

    @Test
    void saveUser (){
        Mockito.when(iUserPersistencePort.saveUser(mockObject)).thenReturn(mockObject);
        User resultObject = userUseCase.saveUser(mockObject);
        Assertions.assertEquals(expectedObject.getId(),resultObject.getId(), "Los ids de los usuarios son iguales");
        Assertions.assertEquals(expectedObject.getName(),resultObject.getName(), "Los ids de los usuarios son iguales");
        Mockito.verify(iUserPersistencePort).saveUser(mockObject);
    }

    @Test
    void getAllUsers (){

    }

    @Test
    void getUser (){
        Mockito.when(iUserPersistencePort.getUser("14124")).thenReturn(mockObject);
        User resultObject = userUseCase.getUser("14124");
        Assertions.assertEquals(expectedObject.getId(),resultObject.getId(), "Los ids de los usuarios son iguales");
        Assertions.assertEquals(expectedObject.getName(),resultObject.getName(), "Los ids de los usuarios son iguales");
        Mockito.verify(iUserPersistencePort).getUser("14124");
    }

    @Test
    void updateUser (){
    }

    @Test
    void deleteUser (){
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
}