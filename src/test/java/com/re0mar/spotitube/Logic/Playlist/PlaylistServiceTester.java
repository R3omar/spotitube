package com.re0mar.spotitube.Logic.Playlist;

import com.re0mar.spotitube.Logic.Login.UserCredDTO;
import com.re0mar.spotitube.Logic.Login.UserService;
import com.re0mar.spotitube.Logic.Track.TrackService;
import com.re0mar.spotitube.dataSource.Playlist.PlaylistDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class PlaylistServiceTester {
    private PlaylistService sut;
    private PlaylistDao daoMock;
    private TrackService trackServiceMock;
    private UserService tokenServiceMock;

    @BeforeEach
    public void setup() {
        this.sut = new PlaylistService();
        this.daoMock = Mockito.mock(PlaylistDao.class);
        this.trackServiceMock = Mockito.mock(TrackService.class);
        this.tokenServiceMock = Mockito.mock(UserService.class);

        sut.setPlaylistDao(daoMock);
        sut.setTrackService(trackServiceMock);
        sut.setTokenService(tokenServiceMock);
    }

    @Test
    public void PlaylistServiceCallsFindSpecific() {
        Mockito.when(daoMock.findSpecific(any(String[].class))).thenReturn(new ArrayList<>());
        Mockito.when(trackServiceMock.getTrackDTOsForPlaylist(any(String.class))).thenReturn(new ArrayList<>());
        Mockito.when(tokenServiceMock.getActiveUser(any(String.class))).thenReturn(new UserCredDTO("", "", 0));


        sut.getPlaylists("");

        Mockito.verify(daoMock).findSpecific(any(String[].class));
    }

    @Test
    public void PlaylistServiceCallsGetTrackDTOsForPlaylist() {
        List<Playlist> var = new ArrayList<>();
        var.add(new Playlist("0", "name", 0));


        Mockito.when(daoMock.findSpecific(any(String[].class))).thenReturn(var);
        Mockito.when(trackServiceMock.getTrackDTOsForPlaylist(any(String.class))).thenReturn(new ArrayList<>());
        Mockito.when(tokenServiceMock.getActiveUser(any(String.class))).thenReturn(new UserCredDTO("", "", 0));

        sut.getPlaylists("");

        Mockito.verify(trackServiceMock).getTrackDTOsForPlaylist(any(String.class));
    }

    @Test
    public void PlaylistServiceCallsGetActiveUser() {
        Mockito.when(daoMock.findSpecific(any(String[].class))).thenReturn(new ArrayList<>());
        Mockito.when(trackServiceMock.getTrackDTOsForPlaylist(any(String.class))).thenReturn(new ArrayList<>());
        Mockito.when(tokenServiceMock.getActiveUser(any(String.class))).thenReturn(new UserCredDTO("", "", 0));

        sut.getPlaylists("");

        Mockito.verify(tokenServiceMock).getActiveUser(any(String.class));
    }

}
