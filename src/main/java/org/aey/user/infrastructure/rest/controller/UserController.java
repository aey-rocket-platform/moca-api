package org.aey.user.infrastructure.rest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.common.entities.errors.MOCAErrorMapper;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.services.UserService;
import org.aey.user.infrastructure.rest.dto.user.CreateUserDto;
import org.aey.user.infrastructure.rest.dto.user.UserAccountDto;
import org.aey.user.infrastructure.rest.dto.user.UserDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/v1/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all users")
    @APIResponse(
            responseCode = "200",
            description = "Get all users",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDto.class)) }
    )
    @APIResponse(
            responseCode = "500",
            description = "Unexpected server error",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON) }
    )
    public Response getAllUsers(
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) {
        return this.userService.getAllActiveUsers(limit, offset)
                .map(pagination -> MOCAResponseMapper.toResponse(MOCAResponseCode.GET_ALL_USERS, pagination))
                .getOrElseGet(MOCAErrorMapper::toResponse);
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get user by id")
    @APIResponse(
            responseCode = "200",
            description = "Get user by id",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDto.class)) }
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
    public Response getUserById(@PathParam("id") String id) {
        return this.userService.getUserById(id)
                .map(UserAccountDto::fromEntity)
                .map(userAcc -> MOCAResponseMapper.toResponse(MOCAResponseCode.GET_USER_BY_ID, userAcc))
                .getOrElseGet(MOCAErrorMapper::toResponse);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Post user")
    @APIResponse(
            responseCode = "200",
            description = "Post user",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDto.class)) }
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid request format",
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
    public Response createUser(CreateUserDto createUserDto) {
        return null;
    }
}
