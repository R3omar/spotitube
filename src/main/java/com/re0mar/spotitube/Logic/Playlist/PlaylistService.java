package com.re0mar.spotitube.Logic.Playlist;

import com.re0mar.spotitube.presentation.Playlist.IPlaylistService;
import com.re0mar.spotitube.presentation.Playlist.NewPlaylistDTO;
import com.re0mar.spotitube.presentation.Playlist.PlaylistDTO;
import com.re0mar.spotitube.Logic.Track.TrackDTO;
import com.re0mar.spotitube.presentation.login.IUserService;
import com.re0mar.spotitube.presentation.track.ITrackService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistService implements IPlaylistService {

    @Inject
    private IPlaylistDao playlistDao;

    @Inject
    private ITrackService trackService;

    @Inject
    private IUserService tokenService;


    @Override
    public playlistResponseItemDTO getPlaylists(String token) {
        List<Playlist> playlists = playlistDao.findSpecific(new String[]{String.valueOf(tokenService.getActiveUser(token).getUserID())});
        return makePlaylistResponseItemDTO(playlists);
    }

    @Override
    public playlistResponseItemDTO addPlaylists(String token, NewPlaylistDTO newList) {
        List<Playlist> playlists = playlistDao.addSpecific(new String[]{newList.getName(), String.valueOf(tokenService.getActiveUser(token).getUserID()), String.valueOf(tokenService.getActiveUser(token).getUserID())});
        return makePlaylistResponseItemDTO(playlists);
    }

    @Override
    public playlistResponseItemDTO deletePlaylist(String token, int playlistID) {
        List<Playlist> playlists = playlistDao.removeSpecific(new String[]{String.valueOf(playlistID), String.valueOf(tokenService.getActiveUser(token).getUserID())});
        return makePlaylistResponseItemDTO(playlists);
    }

    private playlistResponseItemDTO makePlaylistResponseItemDTO(List<Playlist> playlists) {
        ArrayList<PlaylistDTO> resPlaylists = new ArrayList<>();

        for (Playlist p: playlists) {
            resPlaylists.add(new com.re0mar.spotitube.presentation.Playlist.PlaylistDTO(p.getId(), p.getName(), true, trackService.getTrackDTOsForPlaylist(p.getId()).toArray(new TrackDTO[0])));
        }

        return new playlistResponseItemDTO(resPlaylists, calculateTotalLength(resPlaylists));
    }


    private int calculateTotalLength(List<com.re0mar.spotitube.presentation.Playlist.PlaylistDTO> playlists) {
        int tot = 0;

        for (com.re0mar.spotitube.presentation.Playlist.PlaylistDTO p: playlists) {
            tot += Arrays.stream(p.getTracks()).mapToInt(TrackDTO::getDuration).sum();
        }

        return tot;
    }

    public void setPlaylistDao(IPlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    public void setTrackService(ITrackService trackService) {
        this.trackService = trackService;
    }

    public void setTokenService(IUserService tokenService) {
        this.tokenService = tokenService;
    }
}
