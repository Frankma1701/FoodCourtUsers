package org.pragma.usersfoodcourt.domain.usecase;

import org.pragma.usersfoodcourt.domain.api.IRoleServicePort;
import org.pragma.usersfoodcourt.domain.api.IUserServicePort;
import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.domain.model.User;
import org.pragma.usersfoodcourt.domain.spi.IRolePersistencePort;
import org.pragma.usersfoodcourt.domain.spi.IUserPersistencePort;

import java.util.List;
// Conection with the infrastructure

public class RoleUseCase implements IRoleServicePort{

    private IRolePersistencePort iRolePersistencePort;

    public RoleUseCase (IRolePersistencePort iRolePersistencePort){
        this.iRolePersistencePort = iRolePersistencePort;
    }

    @Override
    public Role saveRole (Role role){
        return iRolePersistencePort.saveRole(role);
    }
    @Override
    public List<Role> getAllRoles (){
        return iRolePersistencePort.getAllRoles();
    }

    @Override
    public Role getRole (Long roleId){
        return  iRolePersistencePort.getRole(roleId);
    }

    @Override
    public void updateRole (Role role){
        iRolePersistencePort.updateRole(role);
    }

    @Override
    public void deleteRole (Long roleId){
        iRolePersistencePort.deleteRole(roleId);
    }
}
