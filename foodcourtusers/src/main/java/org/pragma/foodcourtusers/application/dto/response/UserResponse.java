package org.pragma.foodcourtusers.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
public class UserResponse {
    private String name;
    private String lastName;
    private String documentId;
    private String cellPhoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Long roleId;
}
