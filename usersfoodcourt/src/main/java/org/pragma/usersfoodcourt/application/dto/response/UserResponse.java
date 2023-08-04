package org.pragma.usersfoodcourt.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.pragma.usersfoodcourt.application.dto.utils.RoleDto;

import java.util.Date;
@Setter
@Getter
public class UserResponse {
    private String name;
    private String lastName;
    private String documentId;
    private String cellPhoneNumber;
    private Date birthDate;
    private String email;
    private String password;
    private RoleDto role;
}
