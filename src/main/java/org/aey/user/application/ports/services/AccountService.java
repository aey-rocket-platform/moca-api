package org.aey.user.application.ports.services;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.user.domain.entities.Account;
import org.aey.user.infrastructure.rest.dto.account.AccountDto;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;

public interface AccountService {
    Uni<Either<MOCAErrorCodes, MOCAResponse<AccountDto>>> getAccountById(String id);
    Uni<Either<MOCAErrorCodes, Account>> createAccount(CreateAccountDto createAccountDto);
}
