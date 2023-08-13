package org.pragma.foodcourtusers.domain.usecase;
import org.pragma.foodcourtusers.domain.api.IRoleServicePort;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort{

    private IRolePersistencePort iRolePersistencePort;

    public RoleUseCase (IRolePersistencePort iRolePersistencePort){
        this.iRolePersistencePort = iRolePersistencePort;
    }

    @Override
    public Role getRole (Long roleId){
        return  iRolePersistencePort.getRole(roleId);
    }

}
