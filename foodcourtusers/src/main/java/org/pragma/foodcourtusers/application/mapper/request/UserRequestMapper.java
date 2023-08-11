package org.pragma.foodcourtusers.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    @Mapping(target = "id", source = "userRequest.roleId")
    Role toRole(UserRequest userRequest);

    @Mapping(target = "name", source = "ownerRequest.name")
    UserRequest toUserRequest(OwnerRequest ownerRequest);
    User toUser(UserRequest userRequest);
}
