package org.pragma.usersfoodcourt.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.usersfoodcourt.application.dto.request.UserRequest;
import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.domain.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {

    @Mapping(target = "id", source = "userRequest.roleId")
    Role toRole(UserRequest userRequest);
    User toUser(UserRequest userRequest);
}
