package org.pragma.foodcourtusers.application.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.application.mapper.request.UserRequestMapper;
import org.pragma.foodcourtusers.application.mapper.response.UserResponseMapper;
import org.pragma.foodcourtusers.domain.api.IUserServicePort;
import org.pragma.foodcourtusers.domain.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort iUserServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public User saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        return iUserServicePort.saveUser(user);
    }

    @Override
    public UserResponse getUser(String documentId) {
        User user = iUserServicePort.getUser(documentId);
        return userResponseMapper.toResponse(user);
    }

}
