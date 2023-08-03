package org.pragma.usersfoodcourt.domain.api;

import org.pragma.usersfoodcourt.domain.model.Role;

import java.util.List;

//Interface that allow create Api
public interface IRoleServicePort {

    Role saveRole(Role role);
    List<Role> getAllRoles();

    Role getRole(Long roleId);

    void updateRole(Role role);

    void deleteRole(Long roleId);

}
