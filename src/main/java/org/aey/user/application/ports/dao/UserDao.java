package org.aey.user.application.ports.dao;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.persistence.jpa.UserJpa;
import org.aey.user.infrastructure.persistence.repositories.UserPostgresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserDao implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    @Inject
    UserPostgresRepository userPostgresRepository;

    @Override
    @WithSession
    public Uni<List<User>> findAll(Integer limit, Integer offset) {
        return this.userPostgresRepository.findAllActiveUsers(limit, offset)
                .onItem().transform(list ->
                        list.stream()
                                .map(UserJpa::toEntity)
                                .toList()
                );
    }

    @Override
    @WithSession
    public Uni<Optional<User>> findOneById(Long id) {
        return userPostgresRepository.findById(id)
                .onItem().transform(userJpa ->
                        userJpa == null
                                ? Optional.empty()
                                : Optional.of(userJpa.toEntity())
                );
    }
}
