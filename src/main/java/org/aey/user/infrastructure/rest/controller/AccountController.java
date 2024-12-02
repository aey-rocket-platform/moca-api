package org.aey.user.infrastructure.rest.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.common.entities.errors.MOCAErrorMapper;
import org.aey.common.entities.responses.MOCAResponseMapper;
import org.aey.user.application.ports.services.AccountService;

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
}
