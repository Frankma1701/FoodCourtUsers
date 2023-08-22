package org.pragma.foodcourtusers.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String documentId;
    private String cellPhoneNumber;
    private LocalDate birthDate;
    private String email;
    private Long roleId;
}
