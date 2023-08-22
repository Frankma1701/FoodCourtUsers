package org.pragma.foodcourtusers.infrastructure.output.jpa.repository;

import org.jetbrains.annotations.NotNull;
import org.pragma.foodcourtusers.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByDocumentId(String documentId);

    @NotNull Optional<UserEntity> findById(@NotNull Long id);


    Optional<UserEntity> findByEmail(String email);
}
