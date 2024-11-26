package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.common.entities.errors.MocaErrorCode;
import org.aey.common.entities.pagination.MocaPagination;
import org.aey.common.entities.responses.MocaResponse;
import org.aey.user.infrastructure.rest.dto.UserDto;

public interface UserService {
    Uni<Either<MocaErrorCode, MocaResponse<UserDto>>> getUserById(Long id);
    Uni<Either<MocaErrorCode, MocaPagination<UserDto>>> getAll(Integer limit, Integer offset);
}
