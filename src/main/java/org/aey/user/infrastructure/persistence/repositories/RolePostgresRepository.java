package org.aey.user.infrastructure.persistence.repositories;

import org.aey.user.infrastructure.persistence.jpa.RoleJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePostgresRepository extends JpaRepository<RoleJpa, Long> {
}
