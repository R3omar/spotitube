package com.re0mar.spotitube.presentation.track;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists/{id}/tracks")
public class TrackResource {

    @Inject
    private ITrackService trackService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleTracks(@QueryParam("token") String token, @PathParam("id") String playlistID) {
        return Response.ok(trackService.getTrackSetForPlaylist(playlistID))
                .status(201)
                .build();
    }

    @Path("/{trackId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrack(@PathParam("id") String listId, @PathParam("trackId") String trackId) {
        return Response.ok(trackService.deleteTrackFromPlaylist(listId, trackId))
                .status(201)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrack(@PathParam("id") String listId, NewTrackDTO newTrack) {
        return Response.ok(trackService.addTrackToPlaylist(listId, newTrack))
                .status(201)
                .build();
    }

    public void setTrackService(ITrackService trackService) {
        this.trackService = trackService;
    }
}
