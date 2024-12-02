package org.aey.user.infrastructure.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.aey.user.infrastructure.persistence.jpa.AccountJpa;

@ApplicationScoped
public class AccountPostgresRepository implements PanacheRepositoryBase<AccountJpa, String> {
}
