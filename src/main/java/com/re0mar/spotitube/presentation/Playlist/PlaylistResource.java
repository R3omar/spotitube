package com.re0mar.spotitube.presentation.Playlist;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/playlists")
public class PlaylistResource {

    @Inject
    private IPlaylistService playlistService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handlePlaylists(@QueryParam("token") String token) {
        var playlists = playlistService.getPlaylists(token);
        return Response.ok(playlists)
                .status(201)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token, NewPlaylistDTO newList) {
        var playlists = playlistService.addPlaylists(token, newList);
        return Response.ok(playlists)
                .status(201)
                .build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@PathParam("id") int playlistID ,@QueryParam("token") String token) {
        var playlists = playlistService.deletePlaylist(token, playlistID);
        return Response.ok(playlists)
                .status(201)
                .build();
    }

    public void setPlaylistService(IPlaylistService service) {
        this.playlistService = service;
    }
}

