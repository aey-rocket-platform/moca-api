package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.pagination.MOCAPagination;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.user.infrastructure.rest.dto.user.CreateUserDto;
import org.aey.user.infrastructure.rest.dto.user.UserDto;

public interface UserService {
    Uni<Either<MOCAErrorCodes, MOCAResponse<UserDto>>> getUserById(String id);
    Uni<Either<MOCAErrorCodes, MOCAPagination<UserDto>>> getAll(Integer limit, Integer offset);
    Uni<Either<MOCAErrorCodes, MOCAResponse<UserDto>>> createUser(CreateUserDto createUserDto);
}
