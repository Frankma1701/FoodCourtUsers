package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.Role;

public interface IRoleServicePort {


    Role getRole(Long roleId);

}
