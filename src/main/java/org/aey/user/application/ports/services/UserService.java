package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.user.infrastructure.rest.dto.UserDto;

public interface UserService {
    Uni<Either<Error, UserDto>> getUserById(Long id);
}
