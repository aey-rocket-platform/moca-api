package org.aey.user.application.implementations;

import io.vavr.control.Either;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

import org.aey.common.entities.errors.MOCAErrorCodes;
import org.aey.user.application.ports.repostitory.RoleRepository;
import org.aey.user.application.ports.services.RoleService;
import org.aey.user.domain.entities.Role;

@ApplicationScoped
public class RoleUseCase implements RoleService {

    @Inject
    RoleRepository roleRepository;


    @Override
    public Either<MOCAErrorCodes, Role> getRoleById(Long roleId) {
        Optional<Role> roleOp = this.roleRepository.findRoleById(roleId);
        if (roleOp.isEmpty()) {
            return Either.left(MOCAErrorCodes.ROLE_NOT_FOUND);
        }
        if (roleOp.get().getIsActive().equals(Boolean.FALSE)) {
            return Either.left(MOCAErrorCodes.ROLE_NOT_AVAILABLE);
        }
        return Either.right(roleOp.get());
    }
}
