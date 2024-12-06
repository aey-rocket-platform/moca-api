package org.aey.user.application.implementations;

import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.pagination.MOCAPagination;
import org.aey.common.entities.pagination.MOCAPaginationMapper;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.application.ports.services.AccountService;
import org.aey.user.application.ports.services.RoleService;
import org.aey.user.application.ports.services.UserService;
import org.aey.user.domain.entities.Account;
import org.aey.user.domain.entities.User;
import org.aey.user.domain.entities.UserAccount;
import org.aey.user.infrastructure.rest.dto.user.CreateUserDto;
import org.aey.user.infrastructure.rest.dto.user.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserUseCase implements UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    RoleService roleService;

    @Inject
    AccountService accountService;

    @Override
    public Either<MOCAErrorCodes, MOCAPagination<UserAccount>> getAllActiveUsers(Integer limit, Integer offset) {
        Integer finalLimit = limit == null ? 10 : limit;
        Integer finalOffset = offset == null ? 0 : offset;
        List<User> users = userRepository.findAll(limit, offset);
        //TODO: Add account, role and gender to user
        List<UserAccount> usersRes = users.stream()
                .map(user -> UserAccount.fromEntity(user, this.accountService.getAccountById(user.getUserId()).get()))
                .collect(Collectors.toList());
        return Either.right(MOCAPaginationMapper.toEntity(usersRes, finalLimit, finalOffset));

    }

    @Override
    public Either<MOCAErrorCodes, UserAccount> getUserById(String id) {
        Optional<User> userOp = this.userRepository.findOneById(id);
        if (userOp.isEmpty()) {
            return Either.left(MOCAErrorCodes.USER_NOT_FOUND);
        }
        if (userOp.get().getIsActive().equals(Boolean.FALSE)) {
            return Either.left(MOCAErrorCodes.USER_NOT_AVAILABLE);
        }
        //TODO: Add account, role and gender
        Account account = new Account();
        return Either.right(UserAccount.fromEntity(userOp.get(), account));
    }

    @Override
    public Either<MOCAErrorCodes, UserAccount> createUser(CreateUserDto createUserDto) {
        return null;
    }
}
