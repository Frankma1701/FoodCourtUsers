package org.pragma.foodcourtusers.domain.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class UserUseCaseTest{

    @Mock
    private IUserPersistencePort iUserPersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    private User mockObject;
    private User mockObject1;

    private User expectedObject;

    private User expectedUpdateObject;




    @BeforeEach
    void setUp(){
        mockObject = new User(1L,"Pedro","Perez", "14124",
                "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
        mockObject1 = new User(1L,"Pedro","Perez", "1452",
                "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);

        expectedObject = new User(1L,"Pedro","Perez", "14124",
                "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
        expectedUpdateObject = new User(1L,"Pedro","Perez", "14124",
                "431124", LocalDate.of(2001,4,13),
                "lopezpedro@hm.co", "pedroperez--",2L);
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
        Mockito.when(iUserPersistencePort.getAllUsers()).thenReturn(Arrays.asList(mockObject,mockObject1));
        Assertions.assertNotNull(userUseCase.getAllUsers());
        userUseCase.saveUser(mockObject);
        userUseCase.saveUser(mockObject1);
        List<User> userList = userUseCase.getAllUsers();
        Assertions.assertNotNull(userList);
        Assertions.assertEquals(2,userList.size());
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
        userUseCase.updateUser(expectedUpdateObject);
        Mockito.verify(iUserPersistencePort).updateUser(expectedUpdateObject);
    }

    @Test
    void deleteUser (){
        String documentId = "123";
        userUseCase.deleteUser(documentId);
        Mockito.verify(iUserPersistencePort).deleteUser(documentId);
    }
}