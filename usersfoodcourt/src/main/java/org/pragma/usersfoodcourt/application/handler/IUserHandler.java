package org.pragma.usersfoodcourt.application.handler;

import org.pragma.usersfoodcourt.application.dto.request.UserRequest;
import org.pragma.usersfoodcourt.application.dto.response.UserResponse;
import org.pragma.usersfoodcourt.domain.model.User;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();

    UserResponse getUser(String documentId);

    void updateUser(UserRequest userRequest);

    void deleteUser(String documentId);
}
