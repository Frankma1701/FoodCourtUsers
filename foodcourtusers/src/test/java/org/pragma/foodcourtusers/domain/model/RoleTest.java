package org.pragma.foodcourtusers.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RoleTest {

    private Role role;

    @BeforeEach
    void setUp() {
        role = new Role(1L, "Admin", "Administrator Role");
    }

    @Test
    void setId() {
        role.setId(2L);
        assertEquals(2L, role.getId());
    }

    @Test
    void setName() {
        role.setName("User");
        assertEquals("User", role.getName());
    }

    @Test
    void setDescription() {
        role.setDescription("Regular User Role");
        assertEquals("Regular User Role", role.getDescription());
    }
}
