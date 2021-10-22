package com.re0mar.spotitube.presentation.track;


import com.re0mar.spotitube.Logic.Track.TrackDTO;
import com.re0mar.spotitube.Logic.Track.TrackSetDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class AllTrackHandlerTest {

    private AllTracksResource sut;
    private ITrackService mock;

    @BeforeEach
    public void setup() {
        sut = new AllTracksResource();

        this.mock = Mockito.mock(ITrackService.class);

        sut.setTrackService(mock);
    }


    @Test
    public void TrackCallsGetAllTracksFunction() {
        var val = new TrackSetDTO(new TrackDTO[0]);

        Mockito.when(mock.getTrackSetForAllTracks()).thenReturn(val);

        assertEquals(val, sut.handleGetAllTracks().getEntity());
    }



}
