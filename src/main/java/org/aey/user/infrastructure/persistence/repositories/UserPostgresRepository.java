package org.aey.user.infrastructure.persistence.repositories;

import org.aey.user.infrastructure.persistence.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostgresRepository extends JpaRepository<UserJpa, String> {
}
