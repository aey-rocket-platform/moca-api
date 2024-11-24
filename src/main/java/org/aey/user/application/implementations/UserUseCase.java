package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    public Uni<Either<Error, UserDto>> getUserById(Long id) {
        return this.userRepository.findOneById(id)
                .onItem().transform(user ->
                    user
                            .<Either<Error, UserDto>>map(u -> Either.right(UserDto.fromEntity(u)))
                            .orElseGet(() -> {
                                LOGGER.error("User not found with id {}", id);
                                return Either.left(new Error("User not found"));
                            })
                );
    }
}
