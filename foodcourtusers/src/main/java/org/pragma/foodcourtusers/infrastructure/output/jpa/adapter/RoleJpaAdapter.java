package org.pragma.foodcourtusers.infrastructure.output.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;
import org.pragma.foodcourtusers.domain.spi.IRolePersistencePort;
import org.pragma.foodcourtusers.domain.spi.IUserPersistencePort;
import org.pragma.foodcourtusers.infrastructure.exception.NoDataFoundException;
import org.pragma.foodcourtusers.infrastructure.exception.RoleNotFoundException;
import org.pragma.foodcourtusers.infrastructure.exception.UserAlreadyExistException;
import org.pragma.foodcourtusers.infrastructure.exception.UserNotFoundException;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.UserEntityMapper;

import java.util.List;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleRepository iRoleRepository;
    private final RoleEntityMapper roleEntityMapper;
    @Override
    public Role getRole(Long roleId) {
        return roleEntityMapper.toRole(iRoleRepository.findById(roleId).orElseThrow(RoleNotFoundException::new));
    }
}
