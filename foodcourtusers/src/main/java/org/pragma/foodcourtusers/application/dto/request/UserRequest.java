package org.pragma.foodcourtusers.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.pragma.foodcourtusers.domain.model.Role;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
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
