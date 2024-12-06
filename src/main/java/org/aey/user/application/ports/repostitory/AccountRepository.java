package org.aey.user.application.ports.repostitory;

import org.aey.user.domain.entities.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findOneById(String id);
    Optional<Account> create(Account account);
}
