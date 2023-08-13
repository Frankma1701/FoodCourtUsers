package org.pragma.foodcourtusers.util;

import org.pragma.foodcourtusers.application.dto.request.UserRequest;
import org.pragma.foodcourtusers.domain.model.User;

import java.time.LocalDate;

public class FactoryUserRequest{

    public static final UserRequest mockObject = new UserRequest("John", "Doe", "123456789", "555-555-5555", LocalDate.of(2000, 1, 1), "john@example.com", "password123", 1L);


}
