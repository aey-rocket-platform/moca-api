package org.aey.user.infrastructure.rest.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.common.entities.errors.MOCAErrorMapper;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.services.AccountService;
import org.aey.user.infrastructure.rest.dto.account.CreateAccountDto;

@Path("v1/accounts")
public class AccountController {

    @Inject
    AccountService accountService;

    @GET
    @Path("account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getAccount(@PathParam("id") String id) {
        return this.accountService.getAccountById(id)
                .onItem().transform(either ->
                        either.map(MOCAResponseMapper::toResponse)
                                .getOrElseGet(MOCAErrorMapper::toResponse)
                );
    }

    @POST
    @Path(("create"))
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> createAccount(CreateAccountDto createAccountDto) {
        return null;
    }
}
