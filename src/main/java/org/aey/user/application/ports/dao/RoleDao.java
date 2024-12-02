package org.aey.user.application.ports.dao;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.user.application.ports.repostitory.RoleRepository;
import org.aey.user.domain.entities.Role;
import org.aey.user.infrastructure.persistence.jpa.RoleJpa;
import org.aey.user.infrastructure.persistence.repositories.RolePostgresRepository;

import java.util.Optional;

@ApplicationScoped
public class RoleDao implements RoleRepository {

    @Inject
    RolePostgresRepository rolePostgresRepository;

    @Override
    @WithSession
    public Uni<Optional<Role>> findRoleById(Long id) {
        return this.rolePostgresRepository.findById(id)
                .onItem().transform(roleJpa ->
                        Optional.ofNullable(roleJpa).map(RoleJpa::toEntity)
                );
    }
}
