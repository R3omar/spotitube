package com.re0mar.spotitube.presentation.track;


import com.re0mar.spotitube.Logic.Track.TrackDTO;
import com.re0mar.spotitube.Logic.Track.TrackSetDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class TrackHandlerTester {

    private TrackResource sut;
    private ITrackService mock;

    @BeforeEach
    public void setup() {
        sut = new TrackResource();

        this.mock = Mockito.mock(ITrackService.class);

        sut.setTrackService(mock);
    }


    @Test
    public void trackCallsGetTracksForPlaylistFunction() {
        var val = new TrackSetDTO(new TrackDTO[0]);

        Mockito.when(mock.getTrackSetForPlaylist(any(String.class))).thenReturn(val);

        assertEquals(val, sut.handleTracks("", "").getEntity());
    }



}
