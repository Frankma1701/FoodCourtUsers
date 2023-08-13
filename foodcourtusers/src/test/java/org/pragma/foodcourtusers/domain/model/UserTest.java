package org.pragma.foodcourtusers.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pragma.foodcourtusers.util.FactoryUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest{

    private User user;
    @BeforeEach
    void setUp (){
        user = FactoryUser.mockObjectSets;
    }

    @Test
    void setId() {
        user.setId(2L);
        assertEquals(2L, user.getId());
    }

    @Test
    void setName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void setLastName() {
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    void setDocumentId() {
        user.setDocumentId("654321");
        assertEquals("654321", user.getDocumentId());
    }

    @Test
    void setCellPhoneNumber() {
        user.setCellPhoneNumber("987-654-3210");
        assertEquals("987-654-3210", user.getCellPhoneNumber());
    }

    @Test
    void setBirthDate() {
        LocalDate newBirthDate = LocalDate.of(1985, 5, 15);
        user.setBirthDate(newBirthDate);
        assertEquals(newBirthDate, user.getBirthDate());
    }

    @Test
    void setEmail() {
        user.setEmail("jane@example.com");
        assertEquals("jane@example.com", user.getEmail());
    }

    @Test
    void setPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    void setRoleId() {
        user.setRoleId(3L);
        assertEquals(3L, user.getRoleId());
    }
}