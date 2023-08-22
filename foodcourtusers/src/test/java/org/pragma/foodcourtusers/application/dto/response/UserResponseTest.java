package org.pragma.foodcourtusers.application.dto.response;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseTest{

    @Test
    public void testGetters() {
        Long id = 1L;
        String name = "Juan";
        String lastName = "Perez";
        String documentId = "123456789";
        String cellPhoneNumber = "123-456-7890";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        String email = "juan@example.com";
        Long roleId = 2L;

        UserResponse userResponse = new UserResponse(id, name, lastName, documentId, cellPhoneNumber, birthDate, email, roleId);

        assertEquals(id, userResponse.getId());
        assertEquals(name, userResponse.getName());
        assertEquals(lastName, userResponse.getLastName());
        assertEquals(documentId, userResponse.getDocumentId());
        assertEquals(cellPhoneNumber, userResponse.getCellPhoneNumber());
        assertEquals(birthDate, userResponse.getBirthDate());
        assertEquals(email, userResponse.getEmail());
        assertEquals(roleId, userResponse.getRoleId());
    }

}