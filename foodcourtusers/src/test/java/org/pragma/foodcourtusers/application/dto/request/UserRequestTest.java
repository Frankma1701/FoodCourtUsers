package org.pragma.foodcourtusers.application.dto.request;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestTest{

    @Test
    public void testGetters() {
        String name = "John";
        String lastName = "Doe";
        String documentId = "123456789";
        String cellPhoneNumber = "123-456-7890";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        String email = "john@example.com";
        String password = "password";
        Long roleId = 1L;

        UserRequest userRequest = new UserRequest(name, lastName, documentId, cellPhoneNumber, birthDate, email, password, roleId);

        assertEquals(name, userRequest.getName());
        assertEquals(lastName, userRequest.getLastName());
        assertEquals(documentId, userRequest.getDocumentId());
        assertEquals(cellPhoneNumber, userRequest.getCellPhoneNumber());
        assertEquals(birthDate, userRequest.getBirthDate());
        assertEquals(email, userRequest.getEmail());
        assertEquals(password, userRequest.getPassword());
        assertEquals(roleId, userRequest.getRoleId());
    }

}