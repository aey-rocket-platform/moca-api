package org.aey.user.application.ports.repostitory;

import org.aey.user.domain.entities.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findRoleById(Long id);
}
