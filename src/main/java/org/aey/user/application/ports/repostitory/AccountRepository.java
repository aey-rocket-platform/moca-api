package org.aey.user.application.ports.repostitory;

import io.smallrye.mutiny.Uni;
import org.aey.user.domain.entities.Account;

import java.util.Optional;

public interface AccountRepository {
    Uni<Optional<Account>> findOneById(String id);
    Uni<Optional<Account>> create(Account account);
}
