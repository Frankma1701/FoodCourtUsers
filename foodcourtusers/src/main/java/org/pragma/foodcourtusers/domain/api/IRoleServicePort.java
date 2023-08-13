package org.pragma.foodcourtusers.domain.api;

import org.pragma.foodcourtusers.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {


    Role getRole(Long roleId);

}
