package org.samid.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaStudentRepository extends JpaRepository<StudentEntity, UUID> {
}
