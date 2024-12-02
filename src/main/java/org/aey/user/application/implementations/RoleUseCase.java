package org.aey.user.application.implementations;

import io.smallrye.mutiny.Uni;
import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.common.entities.responses.MOCAResponse;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.repostitory.RoleRepository;
import org.aey.user.application.ports.services.RoleService;
import org.aey.user.infrastructure.rest.dto.role.RoleDto;

@ApplicationScoped
public class RoleUseCase implements RoleService {

    @Inject
    RoleRepository roleRepository;


    @Override
    public Uni<Either<MOCAErrorCodes, MOCAResponse<RoleDto>>> getRoleById(Long roleId) {
        return this.roleRepository.findRoleById(roleId)
                .onItem().transform(roleOp -> {
                    if (roleOp.isEmpty()) {
                        return Either.left(MOCAErrorCodes.ROLE_NOT_FOUND);
                    }
                    if (roleOp.get().getIsActive().equals(Boolean.FALSE)) {
                        return Either.left(MOCAErrorCodes.ROLE_NOT_AVAILABLE);
                    }
                    return Either.right(MOCAResponseMapper.toEntity(MOCAResponseCode.GET_ROLE_BY_ID, RoleDto.fromEntity(roleOp.get())));
                });
    }
}
