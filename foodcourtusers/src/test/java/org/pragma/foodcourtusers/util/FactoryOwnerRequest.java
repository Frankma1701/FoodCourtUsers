package org.pragma.foodcourtusers.util;

import org.pragma.foodcourtusers.application.dto.request.OwnerRequest;
import org.pragma.foodcourtusers.application.dto.request.UserRequest;

import java.time.LocalDate;

public class FactoryOwnerRequest{

    public static final OwnerRequest mockObject = new OwnerRequest("John", "Doe", "123456789", "555-555-5555", LocalDate.of(2000, 1, 1), "john@example.com", "password123");
}
