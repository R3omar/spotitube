package com.re0mar.spotitube.Logic.Track;

import com.re0mar.spotitube.dataSource.Track.MovieDao;
import com.re0mar.spotitube.dataSource.Track.SongDao;
import com.re0mar.spotitube.presentation.track.ITrackService;
import com.re0mar.spotitube.presentation.track.NewTrackDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TrackService implements ITrackService {

    @Inject
    private IMovieDao movieDao;

    @Inject
    private ISongDao songDao;

    private List<Track> getTracksForPlaylist(String playlistID) {
        List<Track> retTracks = new ArrayList<Track>();

        retTracks.addAll(movieDao.findSpecific(new String[]{playlistID}));
        retTracks.addAll(songDao.findSpecific(new String[]{playlistID}));

        return retTracks;
    }

    private List<Track> getAllTracks() {
        List<Track> retTracks = new ArrayList<Track>();

        retTracks.addAll(movieDao.findAll());
        retTracks.addAll(songDao.findAll());

        return retTracks;
    }

    @Override
    public List<TrackDTO> getTrackDTOsForPlaylist(String playlistID) {
        List<Track> tracks = getTracksForPlaylist(playlistID);
        return getTrackDTOS(tracks);
    }

    @Override
    public List<TrackDTO> getTrackDTOsForAllTracks() {
        List<Track> tracks = getAllTracks();
        return getTrackDTOS(tracks);
    }

    private List<TrackDTO> getTrackDTOS(List<Track> tracks) {
        List<TrackDTO> retTracks = new ArrayList<TrackDTO>();

        for (Track t: tracks) {
            retTracks.add(new TrackDTO(t.getTrackID(), t.getTitle(),
                    t.getPerformer(), t.getUrl(), t.getDuration(),
                    t.isOffline(), t.getAlbum(), t.getPublishDate(),
                    t.getDescription()));
        }

        return retTracks;
    }

    @Override
    public TrackSetDTO getTrackSetForPlaylist(String playlistID) {
        return new TrackSetDTO(getTrackDTOsForPlaylist(playlistID).toArray(new TrackDTO[0]));
    }

    @Override
    public TrackSetDTO getTrackSetForAllTracks() {
        return new TrackSetDTO(getTrackDTOsForAllTracks().toArray(new TrackDTO[0]));
    }

    public TrackSetDTO deleteTrackFromPlaylist(String playlistID, String trackID) {
        List<Track> tracks = songDao.removeSpecific(new String[]{trackID});
        tracks.addAll(movieDao.removeSpecific(new String[]{trackID, playlistID}));
        return new TrackSetDTO(getTrackDTOS(tracks).toArray(new TrackDTO[0]));
    }

    public TrackSetDTO addTrackToPlaylist(String playlistID, NewTrackDTO track) {
        List<Track> tracks;
        if(track.getDescription() == null && track.getAlbum() != null) {
        tracks = songDao.addSpecific(new String[]{playlistID, track.getTitle(), track.getPerformer(), track.getUrl(),
                String.valueOf(track.getDuration()), track.getAlbum(), "0", String.valueOf(track.isOfflineAvailable()), playlistID
        });
        tracks.addAll(movieDao.findSpecific(new String[]{playlistID}));
        } else {
            tracks = movieDao.addSpecific(new String[]{playlistID, track.getTitle(), track.getPerformer(), track.getUrl(),
                    String.valueOf(track.getDuration()), track.getPublicationDate(), track.getDescription(), "0",
                    String.valueOf(track.isOfflineAvailable()), playlistID
            });
            tracks.addAll(songDao.findSpecific(new String[]{playlistID}));
        }

        return new TrackSetDTO(getTrackDTOS(tracks).toArray(new TrackDTO[0]));
    }

    public void setMovieDao(IMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public void setSongDao(ISongDao songDao) {
        this.songDao = songDao;
    }
}
