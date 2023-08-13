package org.pragma.foodcourtusers.domain.usecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;
import org.pragma.foodcourtusers.util.ConstantsTests;
import org.pragma.foodcourtusers.util.FactoryRole;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)

class RoleUseCaseTest{
    @Mock
    private IRolePersistencePort iRolePersistencePort;
    @InjectMocks
    private RoleUseCase roleUseCase;
    @Test
    void getRole (){
        Mockito.when(iRolePersistencePort.getRole(ConstantsTests.ID_ROLE_TO_ASK)).thenReturn(FactoryRole.mockObject);
        Role resultObject = roleUseCase.getRole(ConstantsTests.ID_ROLE_TO_ASK);
        assertEquals(FactoryRole.expectedObject.getId(),resultObject.getId(), ConstantsTests.ID_ROLE_EQUAL);
        assertEquals(FactoryRole.expectedObject.getName(),resultObject.getName(), ConstantsTests.NAME_ROLE_EQUAL);
        assertEquals(FactoryRole.expectedObject.getDescription(),resultObject.getDescription(), ConstantsTests.DESCRIPTION_ROLE_EQUAL);
        verify(iRolePersistencePort).getRole(ConstantsTests.ID_ROLE_TO_ASK);

    }
}