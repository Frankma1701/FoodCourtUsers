package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {

    Role saveRole(Role role);
    List<Role> getAllRoles();

    Role getRole(Long roleId);

    void updateRole(Role role);

    void deleteRole(Long roleId);

}
