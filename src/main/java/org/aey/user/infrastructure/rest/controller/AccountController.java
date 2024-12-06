package org.aey.user.infrastructure.rest.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.common.entities.errors.MOCAErrorMapper;
import org.aey.common.entities.responses.MOCAResponseCode;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.services.AccountService;
import org.aey.user.infrastructure.rest.dto.account.AccountDto;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;
import org.aey.user.infrastructure.rest.dto.role.RoleDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("v1/accounts")
public class AccountController {

    @Inject
    AccountService accountService;

    @GET
    @Path("account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get account by id")
    @APIResponse(
            responseCode = "200",
            description = "Get account by id",
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
    public Response getAccountById(@PathParam("id") String id) {
        return this.accountService.getAccountById(id)
                .map(AccountDto::fromEntity)
                .map(accountDto -> MOCAResponseMapper.toResponse(MOCAResponseCode.GET_ACCOUNT, accountDto))
                .getOrElseGet(MOCAErrorMapper::toResponse);
    }

    @POST
    @Path(("create"))
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(CreateAccountDto createAccountDto) {
        return null;
    }
}
