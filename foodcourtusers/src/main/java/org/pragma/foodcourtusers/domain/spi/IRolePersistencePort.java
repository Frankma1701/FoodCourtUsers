package org.pragma.foodcourtusers.domain.spi;

import org.pragma.foodcourtusers.domain.model.Role;

public interface IRolePersistencePort {

    Role getRole(Long roleId);

}
