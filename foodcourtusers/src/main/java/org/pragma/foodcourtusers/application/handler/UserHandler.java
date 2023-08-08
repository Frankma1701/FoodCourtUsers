package org.pragma.foodcourtusers.application.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.mapper.request.RoleDtoMapper;
import org.pragma.foodcourtusers.application.mapper.request.UserRequestMapper;
import org.pragma.foodcourtusers.application.mapper.response.UserResponseMapper;
import org.pragma.foodcourtusers.domain.api.IRoleServicePort;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.Role;
import org.pragma.foodcourtusers.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort iUserServicePort;
    private final IRoleServicePort iRoleServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final RoleDtoMapper roleDtoMapper;


    @Override
    public void saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        iUserServicePort.saveUser(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userResponseMapper.toResponseList(iUserServicePort.getAllUsers());
    }

    @Override
    public UserResponse getUser(String documentId) {
        User user = iUserServicePort.getUser(documentId);
        Role role = iRoleServicePort.getRole(user.getRoleId());
        return userResponseMapper.toResponse(user,roleDtoMapper.toDto(role));
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        User oldUser = iUserServicePort.getUser(userRequest.getDocumentId());
        Role newRole = userRequestMapper.toRole(userRequest);
        newRole.setId(oldUser.getRoleId());
        iRoleServicePort.updateRole(newRole);
        User newUser = userRequestMapper.toUser(userRequest);
        newUser.setId(oldUser.getId());
        newUser.setId(oldUser.getId());
        iUserServicePort.updateUser(newUser);
    }

    @Override
    public void deleteUser(String documentId) {
        User user = iUserServicePort.getUser(documentId);
        iRoleServicePort.deleteRole(user.getRoleId());
        iUserServicePort.deleteUser(documentId);
    }


}
