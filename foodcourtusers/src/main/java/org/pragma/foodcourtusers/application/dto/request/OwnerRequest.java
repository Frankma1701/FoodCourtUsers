package org.pragma.foodcourtusers.application.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OwnerRequest{

    private String name;
    private String lastName;
    private String documentId;
    private String cellPhoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
}
