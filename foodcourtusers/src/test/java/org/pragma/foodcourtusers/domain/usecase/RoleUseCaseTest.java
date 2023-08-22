package org.pragma.foodcourtusers.domain.usecase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;
import org.pragma.foodcourtusers.util.FactoryUser;
import org.pragma.foodcourtusers.util.MessageTestEnum;
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
        Mockito.when(iRolePersistencePort.getRole(FactoryUser.ID_ROLE_TO_ASK)).thenReturn(FactoryRole.mockObject);
        Role resultObject = roleUseCase.getRole(FactoryUser.ID_ROLE_TO_ASK);
        assertEquals(FactoryRole.expectedObject.getId(),resultObject.getId(), FactoryUser.ID_ROLE_TO_ASK);
        assertEquals(FactoryRole.expectedObject.getName(),resultObject.getName(), MessageTestEnum.NAME_ROLE_EQUAL.getMessage());
        assertEquals(FactoryRole.expectedObject.getDescription(),resultObject.getDescription(), MessageTestEnum.DESCRIPTION_ROLE_EQUAL.getMessage());
        verify(iRolePersistencePort).getRole(FactoryUser.ID_ROLE_TO_ASK);

    }
}