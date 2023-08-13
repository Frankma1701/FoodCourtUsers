package org.pragma.foodcourtusers.util;

import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.application.dto.response.UserResponse;

import java.time.LocalDate;

public class FactoryUserResponse{

    public static final UserResponse mockObject = new UserResponse(1L,"John", "Doe", "123456789", "555-555-5555", LocalDate.of(2000, 1, 1), "john@example.com",  1L);

    public static final UserResponse expectedObject = new UserResponse(1L,"John", "Doe", "123456789", "555-555-5555", LocalDate.of(2000, 1, 1), "john@example.com",  1L);

}
