package org.aey.user.application.ports.repostitory;

import io.smallrye.mutiny.Uni;
import org.aey.user.domain.entities.Role;

import java.util.Optional;

public interface RoleRepository {
    Uni<Optional<Role>> findRoleById(Long id);
}
