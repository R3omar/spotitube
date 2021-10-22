package com.re0mar.spotitube.DataSource.Track;

import com.re0mar.spotitube.DataSource.ScriptRunner;
import com.re0mar.spotitube.Logic.Track.Track;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import com.re0mar.spotitube.dataSource.Track.SongDao;
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

public class SongDaoTester {
    private SongDao sut;


    @BeforeEach
    public void setup() {
        sut = new SongDao();

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
    public void SongDaoFindsAllIsZero() {
        Assertions.assertEquals(0, sut.findAll().size());
    }

    @Test
    public void MovieDaoFindSpecificIsZero() {
        Assertions.assertEquals(0, sut.findSpecific(new String[]{""}).size());
    }

    @Test
    public void MovieDaoDeleteSpecificIsZero() {
        Assertions.assertEquals(0, sut.removeSpecific(new String[]{""}).size());
    }

    //(playlistID, name, performer, url, length, album, playcount, offline)

    @Test
    public void SongDaoAddSpecificIsOne() {
        Assertions.assertEquals(0, sut.addSpecific(new String[]{"1","test", "test", "test", "543", "test", "1", "0"}).size());
    }

    @Test
    public void SongDaoFindsAllIsOne() {
        sut.addSpecific(new String[]{"1","test", "test", "test", "543", "test", "1", "0"});
        Assertions.assertEquals(0, sut.findAll().size());
    }


    @Test
    public void SongDaoMakesEmptyResultset() throws SQLException{
        ResultSet mock = Mockito.mock(ResultSet.class);
        when(mock.getString("name")).thenReturn("t");
        when(mock.getInt("length")).thenReturn(0);
        when(mock.getInt("ID")).thenReturn(0);
        when(mock.getString("performer")).thenReturn("t");
        when(mock.getString("url")).thenReturn("t");
        when(mock.getString("publicDate")).thenReturn("t");
        when(mock.getBoolean("offline")).thenReturn(false);

        List<Track> result = new ArrayList<>();
        sut.createListFromResultSet(mock, result);
        Assertions.assertEquals(1, result.size());
    }
}
