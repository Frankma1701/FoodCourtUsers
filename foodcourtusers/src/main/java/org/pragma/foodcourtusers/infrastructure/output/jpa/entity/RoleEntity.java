package org.pragma.foodcourtusers.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "roleEntity" , cascade = CascadeType.ALL)
    private List<UserEntity> users;
}
