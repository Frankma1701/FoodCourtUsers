package org.pragma.foodcourtusers.domain.usecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.util.MessageTestEnum;
import org.pragma.foodcourtusers.util.FactoryUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserUseCaseTest{
    @Mock
    private IUserPersistencePort iUserPersistencePort;
    @InjectMocks
    private UserUseCase userUseCase;
    @Test
    void saveUser (){
        User expectedObject = FactoryUser.expectedObject;
        when(iUserPersistencePort.saveUser(FactoryUser.mockObject)).thenReturn(FactoryUser.mockObject);
        User resultObject = userUseCase.saveUser(FactoryUser.mockObject);
        assertEquals(expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getPassword(),resultObject.getPassword(), MessageTestEnum.PASSWORD_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
        verify(iUserPersistencePort).saveUser(FactoryUser.mockObject);
    }
    @Test
    void getUser (){
        User expectedObject = FactoryUser.expectedObject;
        Mockito.when(iUserPersistencePort.getUser(FactoryUser.DOCUMENT_ID_USER_TO_ASK)).thenReturn(FactoryUser.mockObject);
        User resultObject = userUseCase.getUser(FactoryUser.DOCUMENT_ID_USER_TO_ASK);
        assertEquals(expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getPassword(),resultObject.getPassword(), MessageTestEnum.PASSWORD_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
        verify(iUserPersistencePort).getUser(FactoryUser.DOCUMENT_ID_USER_TO_ASK);
    }

    @Test
    public void getUserById() {
        Long userId = FactoryUser.ID_USER_TO_ASK;
        User expectedObject = FactoryUser.expectedObject;
        expectedObject.setId(userId);
        when(iUserPersistencePort.getUserById(userId)).thenReturn(expectedObject);
        User resultObject = userUseCase.getUserById(userId);
        assertEquals(expectedObject, resultObject);
        verify(iUserPersistencePort, times(1)).getUserById(userId);
        verifyNoMoreInteractions(iUserPersistencePort);
        assertEquals(expectedObject.getId(),resultObject.getId(), MessageTestEnum.ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getLastName(),resultObject.getLastName(), MessageTestEnum.LASTNAME_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getDocumentId(),resultObject.getDocumentId(), MessageTestEnum.DOCUMENT_ID_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), MessageTestEnum.CELL_PHONE_NUMBER_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getBirthDate(),resultObject.getBirthDate(), MessageTestEnum.BIRTH_DATE_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getEmail(),resultObject.getEmail(), MessageTestEnum.EMAIL_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getPassword(),resultObject.getPassword(), MessageTestEnum.PASSWORD_USER_EQUAL.getMessage());
        assertEquals(expectedObject.getRoleId(),resultObject.getRoleId(), MessageTestEnum.ROLE_ID_USER_EQUAL.getMessage());
    }
}