package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.user.domain.entities.Role;

public interface RoleService {
    Uni<Either<MOCAErrorCodes, Role>> getRoleById(Long roleId);
}
