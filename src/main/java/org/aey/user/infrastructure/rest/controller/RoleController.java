package org.aey.user.infrastructure.rest.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.common.entities.errors.MOCAErrorMapper;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.services.RoleService;
import org.aey.user.infrastructure.rest.dto.role.CreateRoleDto;
import org.aey.user.infrastructure.rest.dto.role.RoleDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/v1/roles")
public class RoleController {

    @Inject
    RoleService roleService;

    @GET
    @Path("role/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get role by id")
    @APIResponse(
            responseCode = "200",
            description = "Get role by id",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = RoleDto.class)) }
    )
    @APIResponse(
            responseCode = "400",
            description = "Resource not available",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON) }
    )
    @APIResponse(
            responseCode = "404",
            description = "Resource not found",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON) }
    )
    @APIResponse(
            responseCode = "500",
            description = "Unexpected server error",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON) }
    )
    public Uni<Response> getRole(@PathParam("id") Long id) {
        return this.roleService.getRoleById(id)
                .onItem().ifNotNull().transform(either ->
                        either.map(MOCAResponseMapper::toResponse)
                                .getOrElseGet(MOCAErrorMapper::toResponse)
                );
    }

    @POST
    @Path("create")
    public Uni<Response> createRole(CreateRoleDto createRoleDto) {
        return null;
    }
}
