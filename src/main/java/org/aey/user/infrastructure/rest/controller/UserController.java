package org.aey.user.infrastructure.rest.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aey.user.application.ports.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Inject
    UserService userService;

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getUserById(@PathParam("id") Long id) {
        return this.userService.getUserById(id)
                .onItem().transform(either ->
                    either.map(userDto -> Response.status(Response.Status.OK).entity(userDto).build())
                            .getOrElseGet(error -> Response.status(500).entity(error).build())
                );
    }
}
