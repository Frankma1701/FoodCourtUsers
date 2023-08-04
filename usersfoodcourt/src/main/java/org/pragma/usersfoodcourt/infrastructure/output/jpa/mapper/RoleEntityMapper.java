package org.pragma.usersfoodcourt.infrastructure.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.infrastructure.output.jpa.entity.RoleEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper{

    RoleEntity toEntity(Role role);

    @Mapping(target = "name", source = "roleEntity.name")
    Role toRole(RoleEntity roleEntity);

    List<Role> toRoleList(List<RoleEntity> roleEntityList);
}
