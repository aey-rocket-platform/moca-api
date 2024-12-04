package org.aey.user.application.ports.dao;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.user.application.ports.repostitory.AccountRepository;
import org.aey.user.domain.entities.Account;
import org.aey.user.infrastructure.persistence.jpa.AccountJpa;
import org.aey.user.infrastructure.persistence.repositories.AccountPostgresRepository;

import java.util.Optional;

@ApplicationScoped
public class AccountDao implements AccountRepository {

    @Inject
    AccountPostgresRepository accountPostgresRepository;

    @Override
    @WithSession
    public Uni<Optional<Account>> findOneById(String id) {
        return this.accountPostgresRepository.findById(id)
                .onItem().transform(accJpa -> Optional.ofNullable(accJpa).map(AccountJpa::toEntity));
    }

    @Override
    @WithSession
    public Uni<Optional<Account>> create(Account account) {
        return this.accountPostgresRepository.persistAndFlush(AccountJpa.fromEntity(account))
                .onItem().ifNotNull().transform(accJpa -> Optional.ofNullable(accJpa).map(AccountJpa::toEntity));
    }
}
