package com.re0mar.spotitube.Logic.Track;

import com.re0mar.spotitube.Logic.Login.UserCredDTO;
import com.re0mar.spotitube.Logic.Playlist.Playlist;
import com.re0mar.spotitube.dataSource.Track.MovieDao;
import com.re0mar.spotitube.dataSource.Track.SongDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class TrackServiceTester {
    private TrackService sut;
    private MovieDao movieDao;
    private SongDao songDao;

    @BeforeEach
    public void setup() {
        this.sut = new TrackService();
        this.songDao = Mockito.mock(SongDao.class);
        this.movieDao = Mockito.mock(MovieDao.class);

        sut.setMovieDao(movieDao);
        sut.setSongDao(songDao);
    }

    @Test
    public void TrackServiceCallsDaoFindSpecific() {
        Mockito.when(movieDao.findSpecific(any())).thenReturn(new ArrayList<>());
        Mockito.when(songDao.findSpecific(any())).thenReturn(new ArrayList<>());

        sut.getTrackSetForPlaylist("1");

        Mockito.verify(movieDao).findSpecific(any(String[].class));
        Mockito.verify(movieDao).findSpecific(any(String[].class));
    }

    @Test
    public void TrackServiceCallsDaoFindAll() {
        Mockito.when(movieDao.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(songDao.findAll()).thenReturn(new ArrayList<>());

        sut.getTrackSetForAllTracks();

        Mockito.verify(movieDao).findAll();
        Mockito.verify(movieDao).findAll();
 }

}
