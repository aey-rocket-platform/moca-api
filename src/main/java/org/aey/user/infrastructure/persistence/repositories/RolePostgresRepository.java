package org.aey.user.infrastructure.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.aey.user.infrastructure.persistence.jpa.RoleJpa;

@ApplicationScoped
public class RolePostgresRepository implements PanacheRepository<RoleJpa> {
}
