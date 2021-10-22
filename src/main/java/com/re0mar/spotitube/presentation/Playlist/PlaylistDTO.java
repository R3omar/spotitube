package com.re0mar.spotitube.presentation.Playlist;

import com.re0mar.spotitube.Logic.Track.TrackDTO;

public class PlaylistDTO {
    private String id;
    private String name;
    private final boolean owner = true;
    private TrackDTO[] tracks;

    public PlaylistDTO(String id, String name, boolean owner, TrackDTO[] tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public TrackDTO[] getTracks() {
        return tracks;
    }

    public void setTracks(TrackDTO[] tracks) {
        this.tracks = tracks;
    }
}
