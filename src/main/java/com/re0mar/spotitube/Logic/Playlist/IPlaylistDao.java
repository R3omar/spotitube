package com.re0mar.spotitube.Logic.Playlist;

import java.util.List;

public interface IPlaylistDao {
    public List<Playlist> findAll();

    public List<Playlist> findSpecific(String[] par);

    public List<Playlist> addSpecific(String[] par);

    public List<Playlist> removeSpecific(String[] par);
}
