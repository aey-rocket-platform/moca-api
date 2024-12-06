package org.aey.user.application.ports.repostitory;

import org.aey.user.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findOneById(String id);
    List<User> findAll(Integer limit, Integer offset);
    Optional<User> createUser(User user);
}
