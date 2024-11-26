package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MocaErrorCode;
import org.aey.common.entities.pagination.MocaPagination;
import org.aey.common.entities.pagination.MocaPaginationMapper;
import org.aey.common.entities.responses.MocaResponse;
import org.aey.common.entities.responses.MocaResponseCode;
import org.aey.common.entities.responses.MocaResponseMapper;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.application.ports.services.UserService;
import org.aey.user.infrastructure.rest.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

@ApplicationScoped
public class UserUseCase implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUseCase.class);

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<Either<MocaErrorCode, MocaPagination<UserDto>>> getAll(Integer limit, Integer offset) {
        Integer finalLimit = limit == null ? 10 : limit;
        Integer finalOffset = offset == null ? 0 : offset;
        return this.userRepository.findAll(limit, offset)
                .onItem().transform(users -> users.stream().map(UserDto::fromEntity).collect(Collectors.toList()))
                .onItem().transform(usersDto -> {
                    if (usersDto == null) {
                        return Either.left(MocaErrorCode.INTERNAL_SERVER_ERROR);
                    }
                    return Either.right(MocaPaginationMapper.toEntity(usersDto, finalLimit, finalOffset));
                });
    }

    @Override
    public Uni<Either<MocaErrorCode, MocaResponse<UserDto>>> getUserById(Long id) {
        return this.userRepository.findOneById(id)
                .onItem().transform(userOp -> {
                    if (userOp == null) {
                        return Either.left(MocaErrorCode.INTERNAL_SERVER_ERROR);
                    }
                    if (userOp.isEmpty()) {
                        return Either.left(MocaErrorCode.NOT_FOUND);
                    }
                    if (userOp.get().getIsActive().equals(Boolean.FALSE)) {
                        return Either.left(MocaErrorCode.RESOURCE_NOT_AVAILABLE);
                    }
                    return Either.right(
                            MocaResponseMapper.toEntity(MocaResponseCode.GET_USER, UserDto.fromEntity(userOp.get()))
                    );
                });
    }
}
