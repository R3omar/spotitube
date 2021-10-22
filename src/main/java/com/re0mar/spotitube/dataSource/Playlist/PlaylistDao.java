package com.re0mar.spotitube.dataSource.Playlist;

import com.re0mar.spotitube.Logic.Playlist.IPlaylistDao;
import com.re0mar.spotitube.dataSource.DAO;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import com.re0mar.spotitube.Logic.Playlist.Playlist;

import javax.enterprise.inject.Default;
import java.sql.*;
import java.util.List;

@Default
public class PlaylistDao extends DAO<Playlist> implements IPlaylistDao {


    public PlaylistDao() {
        super(new DatabaseProperties());
    }

    @Override
    protected String query() {
        return "SELECT * FROM Playlists";
    }

    @Override
    protected String searchQuery() {
        return "SELECT * FROM Playlists WHERE ownerID = ?";
    }

    @Override
    protected String addQuery() { return "INSERT INTO Playlists (name, ownerID) VALUES (?, ?) \n SELECT * FROM Playlists WHERE ownerID = ?"; }

    @Override
    protected String deleteQuery() {
        return "DELETE FROM Playlists WHERE playlistID = ? \n SELECT * FROM Playlists WHERE ownerID = ?"; }

    @Override
    public void createListFromResultSet(ResultSet resultSet, List<Playlist> all) throws SQLException {
        all.add(new Playlist(
                resultSet.getString("playlistID"),
                resultSet.getString("name"),
                resultSet.getInt("ownerID")
        ));
    }
}
