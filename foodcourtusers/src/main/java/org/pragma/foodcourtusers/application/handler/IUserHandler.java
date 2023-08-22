package org.pragma.foodcourtusers.application.handler;

import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;
import org.pragma.foodcourtusers.domain.model.User;

public interface IUserHandler {

    User saveUser(UserRequest userRequest);

    UserResponse getUser(String documentId);

    UserResponse getUserById(Long id);


}
