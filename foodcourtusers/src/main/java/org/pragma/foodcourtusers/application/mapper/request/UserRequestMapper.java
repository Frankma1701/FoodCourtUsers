package org.pragma.foodcourtusers.application.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.domain.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {


    User toUser(UserRequest userRequest);
}
