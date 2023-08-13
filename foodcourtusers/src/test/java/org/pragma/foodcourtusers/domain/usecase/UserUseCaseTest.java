package org.pragma.foodcourtusers.domain.usecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.util.ConstantsTests;
import org.pragma.foodcourtusers.util.FactoryUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserUseCaseTest{
    @Mock
    private IUserPersistencePort iUserPersistencePort;
    @InjectMocks
    private UserUseCase userUseCase;
    @Test
    void saveUser (){
        when(iUserPersistencePort.saveUser(FactoryUser.mockObject)).thenReturn(FactoryUser.mockObject);
        User resultObject = userUseCase.saveUser(FactoryUser.mockObject);
        assertEquals(FactoryUser.expectedObject.getId(),resultObject.getId(), ConstantsTests.ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getName(),resultObject.getName(), ConstantsTests.NAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getLastName(),resultObject.getLastName(), ConstantsTests.LASTNAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getDocumentId(),resultObject.getDocumentId(), ConstantsTests.DOCUMENT_ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), ConstantsTests.CELL_PHONE_NUMBER_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getBirthDate(),resultObject.getBirthDate(), ConstantsTests.BIRTH_DATE_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getEmail(),resultObject.getEmail(), ConstantsTests.EMAIL_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getPassword(),resultObject.getPassword(), ConstantsTests.PASSWORD_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getRoleId(),resultObject.getRoleId(), ConstantsTests.ROLE_ID_USER_EQUAL);
        verify(iUserPersistencePort).saveUser(FactoryUser.mockObject);
    }
    @Test
    void getUser (){
        Mockito.when(iUserPersistencePort.getUser(ConstantsTests.DOCUMENT_ID_USER_TO_ASK)).thenReturn(FactoryUser.mockObject);
        User resultObject = userUseCase.getUser(ConstantsTests.DOCUMENT_ID_USER_TO_ASK);
        assertEquals(FactoryUser.expectedObject.getId(),resultObject.getId(), ConstantsTests.ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getName(),resultObject.getName(), ConstantsTests.NAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getLastName(),resultObject.getLastName(), ConstantsTests.LASTNAME_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getDocumentId(),resultObject.getDocumentId(), ConstantsTests.DOCUMENT_ID_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getCellPhoneNumber(),resultObject.getCellPhoneNumber(), ConstantsTests.CELL_PHONE_NUMBER_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getBirthDate(),resultObject.getBirthDate(), ConstantsTests.BIRTH_DATE_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getEmail(),resultObject.getEmail(), ConstantsTests.EMAIL_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getPassword(),resultObject.getPassword(), ConstantsTests.PASSWORD_USER_EQUAL);
        assertEquals(FactoryUser.expectedObject.getRoleId(),resultObject.getRoleId(), ConstantsTests.ROLE_ID_USER_EQUAL);
        verify(iUserPersistencePort).getUser(ConstantsTests.DOCUMENT_ID_USER_TO_ASK);
    }
}