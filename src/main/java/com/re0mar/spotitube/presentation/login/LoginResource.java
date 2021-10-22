package com.re0mar.spotitube.presentation.login;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @Inject
    private IUserService userService;

    private Object UserToken;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginCheck(UserDTO u)  {
        var loginCred = userService.login(u);
        return Response.ok(loginCred)
                .status(201)
                .build();
    }

    @Inject
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
