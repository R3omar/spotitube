package com.re0mar.spotitube.presentation.track;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tracks")
public class AllTracksResource {

    @Inject
    private ITrackService trackService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleGetAllTracks() {
        return Response.ok(trackService.getTrackSetForAllTracks())
                .status(201)
                .build();
    }

    public void setTrackService(ITrackService trackService) {
        this.trackService = trackService;
    }
}
