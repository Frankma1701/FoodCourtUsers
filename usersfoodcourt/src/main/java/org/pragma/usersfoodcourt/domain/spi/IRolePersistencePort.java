package org.pragma.usersfoodcourt.domain.spi;

import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.domain.model.User;

import java.util.List;

public interface IRolePersistencePort {
    Role saveRole(Role role);
    List<Role> getAllRoles();

    Role getRole(Long roleId);

    void updateRole(Role role);

    void deleteRole(Long roleId);
}
