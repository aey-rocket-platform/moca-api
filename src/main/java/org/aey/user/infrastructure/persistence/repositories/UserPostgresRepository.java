package org.aey.user.infrastructure.persistence.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.aey.user.infrastructure.persistence.jpa.UserJpa;

public interface UserRepository extends PanacheRepositoryBase<UserJpa, String> {
}
