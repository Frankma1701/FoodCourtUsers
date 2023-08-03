package org.pragma.usersfoodcourt.application.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pragma.usersfoodcourt.application.dto.request.UserRequest;
import org.pragma.usersfoodcourt.application.dto.response.UserResponse;
import org.pragma.usersfoodcourt.application.mapper.request.RoleDtoMapper;
import org.pragma.usersfoodcourt.application.mapper.request.UserRequestMapper;
import org.pragma.usersfoodcourt.application.mapper.response.UserResponseMapper;
import org.pragma.usersfoodcourt.domain.api.IRoleServicePort;
import org.pragma.usersfoodcourt.domain.api.IUserServicePort;
import org.pragma.usersfoodcourt.domain.model.Role;
import org.pragma.usersfoodcourt.domain.model.User;
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
        Role role = iRoleServicePort.saveRole(iRoleServicePort.getRole(userRequest.getRoleId()));
        System.out.println("Id del rol de usuario desde el handler" + role.getId());
        User user = userRequestMapper.toUser(userRequest);
        System.out.println("Nombre de usuario desde el handler" + user.getName());
        user.setRoleId(role.getId());
        iUserServicePort.saveUser(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userResponseMapper.toResponseList(iUserServicePort.getAllUsers(),iRoleServicePort.getAllRoles());
    }

    @Override
    public UserResponse getUser(String documentId) {
        User user = iUserServicePort.getUser(documentId);
        Role role = iRoleServicePort.getRole(user.getRoleId());
        System.out.println("El rol id que llega al handler es " + role.getId());
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
        iRoleServicePort.deleteRole(Long.valueOf(user.getRoleId()));
        iUserServicePort.deleteUser(documentId);
    }


}
