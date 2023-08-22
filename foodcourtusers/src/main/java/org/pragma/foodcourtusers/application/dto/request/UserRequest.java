package org.pragma.foodcourtusers.application.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserRequest {

    private String name;
    private String lastName;
    private String documentId;
    private String cellPhoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Long roleId;

}
