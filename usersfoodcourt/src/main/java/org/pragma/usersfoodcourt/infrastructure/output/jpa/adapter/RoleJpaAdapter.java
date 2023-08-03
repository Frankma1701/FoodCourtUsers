package org.pragma.usersfoodcourt.infrastructure.output.jpa.adapter;

import lombok.RequiredArgsConstructor;
import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.domain.model.User;
import org.pragma.usersfoodcourt.domain.spi.IRolePersistencePort;
import org.pragma.usersfoodcourt.domain.spi.IUserPersistencePort;
import org.pragma.usersfoodcourt.infrastructure.exception.NoDataFoundException;
import org.pragma.usersfoodcourt.infrastructure.exception.UserAlreadyExistException;
import org.pragma.usersfoodcourt.infrastructure.exception.UserNotFoundException;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.entity.RoleEntity;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.entity.UserEntity;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.repository.IUserRepository;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper.UserEntityMapper;

import java.util.List;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleRepository iRoleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Role saveRole(Role role) {
        return roleEntityMapper.toRole(iRoleRepository.save(roleEntityMapper.toEntity(role)));
    }

    @Override
    public List<Role> getAllRoles() {
        List<RoleEntity> roleEntityList = iRoleRepository.findAll();
        if(roleEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return roleEntityMapper.toRoleList(roleEntityList);
    }

    @Override
    public Role getRole(Long roleId) {
        return roleEntityMapper.toRole(iRoleRepository.findById(roleId).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public void updateRole(Role role) {
        iRoleRepository.save(roleEntityMapper.toEntity(role));

    }

    @Override
    public void deleteRole(Long roleId) {
        iRoleRepository.deleteById(roleId);
    }
}
