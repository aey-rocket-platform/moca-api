package org.aey.user.infrastructure.persistence.repositories;

import org.aey.user.infrastructure.persistence.jpa.AccountJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountPostgresRepository extends JpaRepository<AccountJpa, String> {
}
