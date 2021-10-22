package com.re0mar.spotitube.presentation.Playlist;

import com.re0mar.spotitube.Logic.Playlist.playlistResponseItemDTO;
import com.re0mar.spotitube.presentation.Playlist.NewPlaylistDTO;
import com.re0mar.spotitube.presentation.Playlist.PlaylistDTO;

public interface IPlaylistService {
    playlistResponseItemDTO getPlaylists(String token);

    playlistResponseItemDTO addPlaylists(String token, NewPlaylistDTO newList);

    playlistResponseItemDTO deletePlaylist(String token, int playlistID);
}
