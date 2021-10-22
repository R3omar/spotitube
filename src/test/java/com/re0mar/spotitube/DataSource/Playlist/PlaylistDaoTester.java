package com.re0mar.spotitube.DataSource.Playlist;

import com.re0mar.spotitube.DataSource.ScriptRunner;
import com.re0mar.spotitube.Logic.Playlist.Playlist;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import com.re0mar.spotitube.dataSource.Playlist.PlaylistDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PlaylistDaoTester {
    private PlaylistDao sut;


    @BeforeEach
    public void setup() {
        sut = new PlaylistDao();

        try {
            DatabaseProperties databaseProperties = new DatabaseProperties();
            Connection connection = DriverManager.getConnection(databaseProperties.get("connectionString"));
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, true);
            scriptRunner.runScript(new InputStreamReader(ClassLoader.getSystemResourceAsStream("testDatabaseReset.sql")));
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void PlaylistDaoFindsAllIsZero() {
        Assertions.assertEquals(0, sut.findAll().size());
    }

    @Test
    public void PlaylistDaoFindSpecificIsZero() {
        Assertions.assertEquals(0, sut.findSpecific(new String[]{""}).size());
    }

    @Test
    public void PlaylistDaoDeleteSpecificIsZero() {
        Assertions.assertEquals(0, sut.removeSpecific(new String[]{""}).size());
    }

    @Test
    public void PlaylistDaoAddSpecificIsOne() {
        Assertions.assertEquals(0, sut.addSpecific(new String[]{"test","1"}).size());
    }

    @Test
    public void PlaylistDaoFindsAllIsOne() {
        sut.addSpecific(new String[]{"test","1"});
        Assertions.assertEquals(0, sut.findAll().size());
    }

    @Test
    public void PlaylistDaoMakesEmptyResultset() throws SQLException{
        ResultSet mock = Mockito.mock(ResultSet.class);
        when(mock.getString("name")).thenReturn("t");
        when(mock.getString("playlistID")).thenReturn("t");
        when(mock.getInt("ownerID")).thenReturn(0);

        List<Playlist> result = new ArrayList<>();
        sut.createListFromResultSet(mock, result);
        Assertions.assertEquals(1, result.size());
    }

}
