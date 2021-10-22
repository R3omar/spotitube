package com.re0mar.spotitube.DataSource;

import com.re0mar.spotitube.dataSource.DAO;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import org.junit.jupiter.api.BeforeEach;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOTester {

    private DAO<String> sut;


    @BeforeEach
    public void setup() {
        sut = new DAO<String>(new DatabaseProperties()) {
            @Override
            protected String query() {
                return "";
            }

            @Override
            protected String searchQuery() {
                return "";
            }

            @Override
            protected String deleteQuery() {
                return "";
            }

            @Override
            protected String addQuery() {
                return "";
            }

            @Override
            protected void createListFromResultSet(ResultSet resultSet, List<String> all) throws SQLException {

            }
        };
    }



}
