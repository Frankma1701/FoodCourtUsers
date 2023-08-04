package org.pragma.foodcourtusers.infrastructure.output.jpa.repository;

import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
}
