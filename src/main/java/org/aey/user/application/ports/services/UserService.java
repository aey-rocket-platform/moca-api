package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.shared.errors.ErrorCode;
import org.aey.user.infrastructure.rest.dto.UserDto;

public interface UserService {
    Uni<Either<ErrorCode, UserDto>> getUserById(Long id);
}
