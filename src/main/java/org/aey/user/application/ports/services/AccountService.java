package org.aey.user.application.ports.services;

import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.user.domain.entities.Account;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;

public interface AccountService {
    Either<MOCAErrorCodes, Account> getAccountById(String id);
    Either<MOCAErrorCodes, Account> createAccount(CreateAccountDto createAccountDto);
}
