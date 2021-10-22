package com.re0mar.spotitube.presentation.Playlist;

import com.re0mar.spotitube.Logic.Track.TrackDTO;

public class NewPlaylistDTO {
    private int id;
    private String name;
    private boolean owner;
    private TrackDTO[] tracks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setOwner(boolean owner) {
        this.owner = owner;
    }
}
