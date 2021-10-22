package com.re0mar.spotitube.presentation.Playlist;

import com.re0mar.spotitube.Logic.Playlist.playlistResponseItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class PlaylistResourceTester {

    private PlaylistResource sut;
    private IPlaylistService mock;

    @BeforeEach
    public void setup() {
        sut = new PlaylistResource();

        this.mock = Mockito.mock(IPlaylistService.class);

        sut.setPlaylistService(mock);
    }


    @Test
    public void playlistCallsGetPlaylistFunction() {
        var val = new playlistResponseItemDTO(new ArrayList<>(), 0);

        Mockito.when(mock.getPlaylists(any(String.class))).thenReturn(val);

        assertEquals(val, sut.handlePlaylists("").getEntity());
    }
    @Test
    public void playlistCallsAddPlaylistFunction() {
        var val = new playlistResponseItemDTO(new ArrayList<>(), 0);

        Mockito.when(mock.addPlaylists(any(String.class), any(NewPlaylistDTO.class))).thenReturn(val);
        Mockito.when(mock.getPlaylists(any(String.class))).thenReturn(val);

        assertEquals(val, sut.addPlaylist("", new NewPlaylistDTO()).getEntity());
    }

    @Test
    public void playlistCallsDeletePlaylistFunction() {
        var val = new playlistResponseItemDTO(new ArrayList<>(), 0);

        Mockito.when(mock.deletePlaylist(any(String.class), any(int.class))).thenReturn(val);
        Mockito.when(mock.getPlaylists(any(String.class))).thenReturn(val);

        assertEquals(val, sut.deletePlaylist(0, "").getEntity());
    }

}
