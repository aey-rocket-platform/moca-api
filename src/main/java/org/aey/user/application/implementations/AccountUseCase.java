package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.common.utils.nanoid.NanoId;
import org.aey.user.application.ports.repostitory.AccountRepository;
import org.aey.user.application.ports.services.AccountService;
import org.aey.user.domain.entities.Account;
import org.aey.user.domain.enums.AccountStatus;
import org.aey.user.infrastructure.rest.dto.account.AccountDto;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;

import java.util.Date;
import java.util.Optional;

@ApplicationScoped
public class AccountUseCase implements AccountService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public Either<MOCAErrorCodes, Account> getAccountById(String id) {
        Optional<Account> accOp = this.accountRepository.findOneById(id);
        if (accOp.isEmpty()) {
            return Either.left(MOCAErrorCodes.ACCOUNT_NOT_FOUND);
        }
        if (accOp.get().getIsActive().equals(Boolean.FALSE)) {
            return Either.left(MOCAErrorCodes.ACCOUNT_NOT_AVAILABLE);
        }
        return Either.right(accOp.get());
    }

    @Override
    public Either<MOCAErrorCodes, Account> createAccount(CreateAccountDto createAccountDto) {
        String nanoid = NanoId.randomNanoId();
        Account account = Account.builder()
                .accountId(nanoid)
                .nickname(createAccountDto.getNickname())
                .email(createAccountDto.getEmail())
                .backupEmail(createAccountDto.getBackupEmail())
                .password(createAccountDto.getPassword())
                .mobilePhone(createAccountDto.getMobilePhone())
                .phoneNumber(createAccountDto.getPhoneNumber())
                .createdAt(new Date())
                .updatedAt(new Date())
                .isActive(Boolean.TRUE)
                .status(AccountStatus.ACTIVE.getStatus())
                .build();
        return null;
        //return this.accountRepository.create(account)
                //.onItem().transform(accOp -> accOp.<Either<MOCAErrorCodes, Account>>map(Either::right)
                        //.orElseGet(() -> Either.left(MOCAErrorCodes.ACCOUNT_ERROR_TO_CREATE))
                //);
    }
}
