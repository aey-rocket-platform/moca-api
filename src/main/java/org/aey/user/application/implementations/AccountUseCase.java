package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.repostitory.AccountRepository;
import org.aey.user.application.ports.services.AccountService;
import org.aey.user.infrastructure.rest.dto.account.AccountDto;

@ApplicationScoped
public class AccountUseCase implements AccountService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public Uni<Either<MOCAErrorCodes, MOCAResponse<AccountDto>>> getAccountById(String id) {
        return this.accountRepository.findOneById(id)
                .onItem().transform(accOp -> {
                    if (accOp.isEmpty()) {
                        return Either.left(MOCAErrorCodes.ACCOUNT_NOT_FOUND);
                    }
                    if (accOp.get().getIsActive().equals(Boolean.FALSE)) {
                        return Either.left(MOCAErrorCodes.ACCOUNT_NOT_AVAILABLE);
                    }
                    return Either.right(
                            MOCAResponseMapper.toEntity(MOCAResponseCode.GET_ACCOUNT, AccountDto.fromEntity(accOp.get()))
                    );
                });
    }
}
