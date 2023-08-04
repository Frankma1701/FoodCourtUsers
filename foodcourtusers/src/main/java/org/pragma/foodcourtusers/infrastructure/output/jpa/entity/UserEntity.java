package org.pragma.foodcourtusers.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pragma.foodcourtusers.infrastructure.validator.LegalAge;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @Pattern(regexp = "\\d+" , message = "El documento deben ser solos números")
    private String documentId;
    @Size(max = 13)
    @Pattern(regexp = "\\+?[0-9]+", message = "El numero de celular no es válido")
    private String cellPhoneNumber;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @LegalAge
    private LocalDate birthDate;
    @Email (message = "El correo {value} no es un correo válido")
    @NotBlank(message = "El correo ingresado no puede estar vacío")
    @NotNull(message = "El correo ingresado no puede ser nulo")
    private String email;
    private String password;
    private Long roleId;
}
