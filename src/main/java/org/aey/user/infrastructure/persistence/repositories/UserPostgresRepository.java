package org.aey.user.infrastructure.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.aey.user.infrastructure.persistence.jpa.UserJpa;

@ApplicationScoped
public class UserPostgresRepository implements PanacheRepositoryBase<UserJpa, Long> {
}
