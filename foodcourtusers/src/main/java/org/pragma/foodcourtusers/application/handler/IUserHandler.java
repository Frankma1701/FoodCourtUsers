package org.pragma.foodcourtusers.application.handler;

import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.domain.model.User;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();

    UserResponse getUser(String documentId);

    void updateUser(UserRequest userRequest);

    void deleteUser(String documentId);
}
