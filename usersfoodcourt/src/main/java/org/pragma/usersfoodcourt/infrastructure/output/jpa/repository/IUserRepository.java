package org.pragma.usersfoodcourt.infrastructure.output.jpa.repository;

import org.pragma.usersfoodcourt.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByDocumentId(String documentId);

    void deleteByDocumentId(String documentId);
}