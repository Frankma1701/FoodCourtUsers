package org.pragma.usersfoodcourt.application.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.pragma.usersfoodcourt.domain.model.Role;

import java.util.Date;

@Getter
@Setter
public class RoleRequest{
    private Long id;
    private String name;
    private String description;

}
