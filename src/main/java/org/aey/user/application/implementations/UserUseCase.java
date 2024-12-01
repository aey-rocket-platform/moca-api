package org.aey.user.application.implementations;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.pagination.MOCAPagination;
import org.aey.common.entities.pagination.MOCAPaginationMapper;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.common.utils.dates.DateUtils;
import org.aey.common.utils.nanoid.NanoId;
import org.aey.common.utils.nanoid.strategies.NanoIdGenerator;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.application.ports.services.UserService;
import org.aey.user.domain.entities.User;
import org.aey.user.infrastructure.rest.dto.user.CreateUserDto;
import org.aey.user.infrastructure.rest.dto.user.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserUseCase implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUseCase.class);

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<Either<MOCAErrorCodes, MOCAPagination<UserDto>>> getAll(Integer limit, Integer offset) {
        Integer finalLimit = limit == null ? 10 : limit;
        Integer finalOffset = offset == null ? 0 : offset;
        return this.userRepository.findAll(limit, offset)
                .onItem().transform(users -> users.stream().map(UserDto::fromEntity).collect(Collectors.toList()))
                .onItem().transform(usersDto -> Either.right(MOCAPaginationMapper.toEntity(usersDto, finalLimit, finalOffset)));
    }

    @Override
    public Uni<Either<MOCAErrorCodes, MOCAResponse<UserDto>>> getUserById(String id) {
        return this.userRepository.findOneById(id)
                .onItem().transform(userOp -> {
                    if (userOp.isEmpty()) {
                        return Either.left(MOCAErrorCodes.USER_NOT_FOUND);
                    }
                    if (userOp.get().getIsActive().equals(Boolean.FALSE)) {
                        return Either.left(MOCAErrorCodes.USER_NOT_AVAILABLE);
                    }
                    return Either.right(
                            MOCAResponseMapper.toEntity(MOCAResponseCode.GET_USER, UserDto.fromEntity(userOp.get()))
                    );
                });
    }

    @Override
    public Uni<Either<MOCAErrorCodes, MOCAResponse<UserDto>>> createUser(CreateUserDto createUserDto) {
        //TODO: Create AccountService first with createAccountService method to persist the account first
        //TODO: Create RoleService and GenderService to assign role and gender into builder
        User userTo = User.builder()
                .userId(NanoId.randomNanoId())
                .name(createUserDto.getName())
                .firstSurname(createUserDto.getFirstSurname())
                .secondSurname(createUserDto.getSecondSurname())
                .birthDate(createUserDto.getBirthDate())
                .createdAt(new Date())
                .updatedAt(new Date())
                .isActive(Boolean.TRUE)
                .build();
        return this.userRepository.createUser(userTo)
                .onItem().transform(userOp -> userOp
                        .<Either<MOCAErrorCodes, MOCAResponse<UserDto>>>map(user -> Either.right(MOCAResponseMapper.toEntity(MOCAResponseCode.CREATE_USER, UserDto.fromEntity(user))))
                        .orElseGet(() -> Either.left(MOCAErrorCodes.USER_ERROR_TO_CREATE))
                );
    }
}
