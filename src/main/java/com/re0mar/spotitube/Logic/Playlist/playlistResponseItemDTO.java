package com.re0mar.spotitube.Logic.Playlist;

import com.re0mar.spotitube.presentation.Playlist.PlaylistDTO;

import java.util.ArrayList;

public class playlistResponseItemDTO {
    private ArrayList<PlaylistDTO> playlists = new ArrayList<PlaylistDTO>();
    private int length;

    public playlistResponseItemDTO(ArrayList<PlaylistDTO> playlists, int length) {
        this.playlists = playlists;
        this.length = length;
    }


    public ArrayList<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
