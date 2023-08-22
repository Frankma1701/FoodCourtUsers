package org.pragma.foodcourtusers.infrastructure.output.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;
import org.pragma.foodcourtusers.infrastructure.exception.RoleNotFoundException;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleRepository iRoleRepository;
    private final RoleEntityMapper roleEntityMapper;
    @Override
    public Role getRole(Long roleId) {
        return roleEntityMapper.toRole(iRoleRepository.findById(roleId).orElseThrow(RoleNotFoundException::new));
    }
}
