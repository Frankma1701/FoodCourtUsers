package org.pragma.foodcourtusers.domain.spi;

import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

public interface IRolePersistencePort {
    Role saveRole(Role role);
    List<Role> getAllRoles();

    Role getRole(Long roleId);

    void updateRole(Role role);

    void deleteRole(Long roleId);
}
