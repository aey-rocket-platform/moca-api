package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.shared.errors.ErrorCode;
import org.aey.user.application.ports.repostitory.UserRepository;
import org.aey.user.application.ports.services.UserService;
import org.aey.user.infrastructure.rest.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class UserUseCase implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUseCase.class);

    @Inject
    UserRepository userRepository;

    @Override
    public Uni<Either<ErrorCode, UserDto>> getUserById(Long id) {
        return this.userRepository.findOneById(id)
                .onItem().transform(userOp -> {
                    if (userOp == null) {
                        return Either.left(ErrorCode.INTERNAL_SERVER_ERROR);
                    }
                    if (userOp.isEmpty()) {
                        return Either.left(ErrorCode.NOT_FOUND);
                    }
                    if (userOp.get().getIsActive().equals(Boolean.FALSE)) {
                        return Either.left(ErrorCode.RESOURCE_NOT_AVAILABLE);
                    }
                    return Either.right(UserDto.fromEntity(userOp.get()));
                });
    }
}
