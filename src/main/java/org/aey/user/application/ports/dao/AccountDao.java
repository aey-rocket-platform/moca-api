package org.aey.user.application.ports.dao;

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
    public Optional<Account> findOneById(String id) {
        return this.accountPostgresRepository
                .findById(id)
                .map(AccountJpa::toEntity);
    }

    @Override
    public Optional<Account> create(Account account) {
        return Optional.ofNullable(
                this.accountPostgresRepository.saveAndFlush(AccountJpa.fromEntity(account)).toEntity()
        );

    }
}
