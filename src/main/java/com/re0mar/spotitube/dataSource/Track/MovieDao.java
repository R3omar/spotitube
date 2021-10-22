package com.re0mar.spotitube.dataSource.Track;

import com.re0mar.spotitube.Logic.Track.IMovieDao;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import com.re0mar.spotitube.dataSource.DAO;
import com.re0mar.spotitube.Logic.Track.Track;

import javax.enterprise.inject.Default;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Default
public class MovieDao extends DAO<Track> implements IMovieDao {

    public MovieDao() {
        super(new DatabaseProperties());
    }

    @Override
    protected String query() {
        return "SELECT * FROM Movies";
    }

    @Override
    protected String searchQuery() {
        return "SELECT * FROM Movies WHERE playlistID = ?";
    }

    @Override
    protected String deleteQuery() {
        return "DELETE FROM Movies WHERE ID = ? \n SELECT * FROM Movies WHERE playlistID = ?";
    }

    @Override
    protected String addQuery() {
        return "INSERT INTO Movies (playlistID, name, performer, url, length, publicDate, description, playcount, offline)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                "\n SELECT * FROM Movies WHERE playlistID = ?";
    }

    @Override
    public void createListFromResultSet(ResultSet resultSet, List<Track> all) throws SQLException {
        all.add(new Track(resultSet.getInt("ID"),
                resultSet.getString("name"),
                resultSet.getString("performer"),
                resultSet.getString("url"),
                resultSet.getInt("length"),
                resultSet.getBoolean("offline"),
                resultSet.getString("publicDate"),
                resultSet.getString("description")));
    }
}
