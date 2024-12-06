package org.aey.user.application.ports.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.persistence.jpa.UserJpa;
import org.aey.user.infrastructure.persistence.queries.UserQueryManager;
import org.aey.user.infrastructure.persistence.repositories.UserPostgresRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserDao implements UserRepository {

    @Inject
    EntityManager entityManager;

    @Inject
    UserPostgresRepository userPostgresRepository;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll(Integer limit, Integer offset) {
        try {
            List<Object[]> queryResult = (List<Object[]>) entityManager
                    .createNativeQuery(UserQueryManager.USERS_PAGINATION)
                    .setParameter(UserQueryManager.PARAM_USER_LIMIT, limit)
                    .setParameter(UserQueryManager.PARAM_USER_OFFSET, offset)
                    .getResultList();
            if (queryResult.isEmpty()) {
                return new ArrayList<>();
            }
            List<User> users = new ArrayList<>();
            queryResult.forEach(user -> users.add(
                    User.builder()
                            .userId((String) user[0])
                            .name((String) user[1])
                            .firstSurname((String) user[2])
                            .secondSurname((String) user[3])
                            .birthDate((Date) user[4])
                            .createdAt((Date) user[5])
                            .updatedAt((Date) user[6])
                            .isActive((Boolean) user[7])
                            .build()
            ));
            return users;
        } catch (Error e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<User> findOneById(String id) {
        return this.userPostgresRepository.findById(id)
                .map(UserJpa::toEntity);
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user) {
        return Optional.ofNullable(
                this.userPostgresRepository.saveAndFlush(UserJpa.fromEntity(user)).toEntity()
        );
    }
}
