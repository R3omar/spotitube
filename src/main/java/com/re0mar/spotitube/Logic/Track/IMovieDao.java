package com.re0mar.spotitube.Logic.Track;

import java.util.List;

public interface IMovieDao {
    public List<Track> findAll();

    public List<Track> findSpecific(String[] par);

    public List<Track> addSpecific(String[] par);

    public List<Track> removeSpecific(String[] par);
}
