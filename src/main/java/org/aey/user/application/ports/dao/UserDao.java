package org.aey.user.application.ports.dao;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.persistence.repositories.UserPostgresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@ApplicationScoped
public class UserDao implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Inject
    UserPostgresRepository userPostgresRepository;

    @Override
    @WithSession
    public Uni<Optional<User>> findOneById(Long id) {
        return userPostgresRepository.findById(id)
                .onItem().transform(userJpa -> userJpa == null ? Optional.empty() : Optional.of(userJpa.toEntity()));
    }
}
