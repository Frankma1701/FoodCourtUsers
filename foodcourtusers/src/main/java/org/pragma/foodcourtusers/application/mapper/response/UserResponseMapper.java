package org.pragma.foodcourtusers.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.dto.utils.RoleDto;
import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    @Mapping(target = "name", source  = "user.name")
    UserResponse toResponse(User user, RoleDto roleDto);

    default List<UserResponse> toResponseList(List<User> userList) {
        return userList.stream()
                .map(user -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setName(user.getName());
                    userResponse.setLastName(user.getLastName());
                    userResponse.setDocumentId(user.getDocumentId());
                    userResponse.setCellPhoneNumber(user.getCellPhoneNumber());
                    userResponse.setBirthDate(user.getBirthDate());
                    userResponse.setEmail(user.getEmail());
                    userResponse.setRoleId(user.getRoleId());
                    return userResponse;
                }).toList();
    }


}
