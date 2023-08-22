package org.pragma.foodcourtusers.application.dto.request;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OwnerRequestTest{

    @Test
    public void testGetters() {
        String name = "Juan";
        String lastName = "Perez";
        String documentId = "123456789";
        String cellPhoneNumber = "123456789";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        String email = "juan@example.com";
        String password = "password";

        OwnerRequest ownerRequest = new OwnerRequest(name, lastName, documentId, cellPhoneNumber, birthDate, email, password);

        assertEquals(name, ownerRequest.getName());
        assertEquals(lastName, ownerRequest.getLastName());
        assertEquals(documentId, ownerRequest.getDocumentId());
        assertEquals(cellPhoneNumber, ownerRequest.getCellPhoneNumber());
        assertEquals(birthDate, ownerRequest.getBirthDate());
        assertEquals(email, ownerRequest.getEmail());
        assertEquals(password, ownerRequest.getPassword());
    }

}