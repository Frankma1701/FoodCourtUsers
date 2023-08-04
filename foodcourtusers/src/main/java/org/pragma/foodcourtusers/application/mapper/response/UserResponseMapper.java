package org.pragma.foodcourtusers.application.mapper.response;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.dto.utils.RoleDto;
import org.pragma.foodcourtusers.application.mapper.request.RoleDtoMapper;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {RoleDtoMapper.class})
public interface UserResponseMapper {

    RoleDtoMapper INSTANCE = Mappers.getMapper(RoleDtoMapper.class);
    @Mapping(target = "name", source  = "user.name")
    UserResponse toResponse(User user, RoleDto roleDto);

    default List<UserResponse> toResponseList(List<User> userList, List<Role> roleList) {
        return userList.stream()
                .map(user -> {
                    System.out.println("El usuario que llega es " + user.getName());
                    UserResponse userResponse = new UserResponse();
                    userResponse.setName(user.getName());
                    userResponse.setLastName(user.getLastName());
                    userResponse.setDocumentId(user.getDocumentId());
                    userResponse.setCellPhoneNumber(user.getCellPhoneNumber());
                    userResponse.setBirthDate(user.getBirthDate());
                    userResponse.setEmail(user.getEmail());
                    userResponse.setPassword(user.getPassword());
                    userResponse.setRole(INSTANCE.toDto(roleList.stream().filter(role -> role.getId().equals(user.getRoleId())).findFirst().orElse(null)));
                    return userResponse;
                }).toList();
    }


}
