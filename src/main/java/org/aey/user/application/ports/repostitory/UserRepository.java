package org.aey.user.application.ports.repostitory;

import io.smallrye.mutiny.Uni;
import org.aey.user.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Uni<Optional<User>> findOneById(String id);
    Uni<List<User>> findAll(Integer limit, Integer offset);
    Uni<Optional<User>> createUser(User user);
}
