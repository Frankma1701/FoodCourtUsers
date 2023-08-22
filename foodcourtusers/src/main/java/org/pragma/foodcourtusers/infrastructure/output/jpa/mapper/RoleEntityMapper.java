package org.pragma.foodcourtusers.infrastructure.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper{



    @Mapping(target = "name", source = "roleEntity.name")
    Role toRole(RoleEntity roleEntity);

}
