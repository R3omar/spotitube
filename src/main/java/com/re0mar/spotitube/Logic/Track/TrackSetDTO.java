package com.re0mar.spotitube.Logic.Track;

public class TrackSetDTO {
    private TrackDTO[] tracks;

    public TrackSetDTO(TrackDTO[] tracks) {
        this.tracks = tracks;
    }

    public TrackDTO[] getTracks() {
        return tracks;
    }

    public void setTracks(TrackDTO[] tracks) {
        this.tracks = tracks;
    }
}
