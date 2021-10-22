package com.re0mar.spotitube.presentation.track;

import com.re0mar.spotitube.Logic.Track.TrackDTO;
import com.re0mar.spotitube.Logic.Track.TrackSetDTO;
import com.re0mar.spotitube.presentation.track.NewTrackDTO;

import java.util.List;

public interface ITrackService {
    public TrackSetDTO getTrackSetForPlaylist(String playlistID);

    public List<TrackDTO> getTrackDTOsForPlaylist(String playlistID);

    public TrackSetDTO getTrackSetForAllTracks();

    public List<TrackDTO> getTrackDTOsForAllTracks();

    public TrackSetDTO deleteTrackFromPlaylist(String playlistID, String trackID);

    public TrackSetDTO addTrackToPlaylist(String playlistID, NewTrackDTO track);

}
