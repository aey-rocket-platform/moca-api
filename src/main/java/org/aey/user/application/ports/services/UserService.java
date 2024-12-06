package org.aey.user.application.ports.services;

import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.pagination.MOCAPagination;
import org.aey.user.domain.entities.UserAccount;
import org.aey.user.infrastructure.rest.dto.user.CreateUserDto;

public interface UserService {
    Either<MOCAErrorCodes, UserAccount> getUserById(String id);
    Either<MOCAErrorCodes, MOCAPagination<UserAccount>>  getAllActiveUsers(Integer limit, Integer offset);
    Either<MOCAErrorCodes, UserAccount> createUser(CreateUserDto createUserDto);
}
