package org.pragma.foodcourtusers.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.pragma.foodcourtusers.application.dto.utils.Roles;
import org.pragma.foodcourtusers.application.validator.LegalAge;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre ingresado no puede estar vacío")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "role_id",foreignKey = @ForeignKey(name = "fk_user_role"))
    private RoleEntity roleEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities (){
        return List.of(new SimpleGrantedAuthority("ROLE_"+ Roles.getNameById(roleEntity.getId())));
    }

    @Override
    public String getPassword (){
        return password;
    }

    @Override
    public String getUsername (){
        return email;
    }

    @Override
    public boolean isAccountNonExpired (){
        return true;
    }

    @Override
    public boolean isAccountNonLocked (){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired (){
        return true;
    }

    @Override
    public boolean isEnabled (){
        return true;
    }
}
