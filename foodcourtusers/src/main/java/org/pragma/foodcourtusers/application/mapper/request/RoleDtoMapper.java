package org.pragma.foodcourtusers.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.application.dto.utils.RoleDto;
import org.pragma.foodcourtusers.domain.model.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleDtoMapper {
    @Mapping(target = "name", source = "role.name")
    RoleDto toDto(Role role);
}
