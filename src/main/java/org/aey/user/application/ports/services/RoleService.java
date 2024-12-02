package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.user.infrastructure.rest.dto.role.RoleDto;

public interface RoleService {
    Uni<Either<MOCAErrorCodes, MOCAResponse<RoleDto>>> getRoleById(Long roleId);
}
