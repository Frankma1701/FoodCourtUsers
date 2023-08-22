package org.pragma.foodcourtusers.infrastructure.output.jpa.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.application.exception.RoleNotFoundException;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;
import org.pragma.foodcourtusers.infrastructure.output.jpa.mapper.RoleEntityMapper;
import org.pragma.foodcourtusers.infrastructure.output.jpa.repository.IRoleRepository;
import org.pragma.foodcourtusers.util.FactoryRole;
import org.pragma.foodcourtusers.util.FactoryUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleJpaAdapterTest{

    @Mock
    private IRoleRepository roleRepository;

    @Mock
    private RoleEntityMapper roleEntityMapper;

    @InjectMocks
    private RoleJpaAdapter roleJpaAdapter;

    @Test
    public void getRole() {
        Long roleId = FactoryUser.ID_ROLE_TO_ASK;
        RoleEntity roleEntity = new RoleEntity();
        Role role = FactoryRole.mockObject;
        when(roleRepository.findById(roleId)).thenReturn(Optional.of(roleEntity));
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(role);
        Role retrievedRole = roleJpaAdapter.getRole(roleId);
        assertNotNull(retrievedRole);
        verify(roleRepository, times(1)).findById(roleId);
        verify(roleEntityMapper, times(1)).toRole(roleEntity);
    }

    @Test
    public void getRoleRoleNotFound() {
        Long roleId = FactoryUser.ID_ROLE_TO_ASK;
        when(roleRepository.findById(roleId)).thenReturn(Optional.empty());
        assertThrows(RoleNotFoundException.class, () -> roleJpaAdapter.getRole(roleId));
        verify(roleRepository, times(1)).findById(roleId);
    }

}