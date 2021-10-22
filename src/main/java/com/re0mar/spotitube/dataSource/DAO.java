package com.re0mar.spotitube.dataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class DAO<T> {

    private DatabaseProperties databaseProperties;

    protected abstract String query();
    protected abstract String searchQuery();
    protected abstract String addQuery();
    protected abstract String deleteQuery();

    public DAO(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public List<T> findAll() {
        List<T> all = new ArrayList<>();
        try {
            Class.forName(databaseProperties.get("driver"));
            Connection connection = DriverManager.getConnection(
                    databaseProperties.get("connectionString"));
            ResultSet resultSet =
                    connection.prepareStatement(query()).executeQuery();
            while(resultSet.next())
            {
                createListFromResultSet(resultSet, all);
            }
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return all;

    }

    public List<T> findSpecific(String[] par) {
        List<T> all = new ArrayList<>();
        try {
            Class.forName(databaseProperties.get("driver"));
            Connection connection = DriverManager.getConnection(
                    databaseProperties.get("connectionString"));
            PreparedStatement ps =
                    connection.prepareStatement(searchQuery());
            for (int i=0; i< par.length; i++)
                ps.setNString(i+1, par[i]);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next())
                createListFromResultSet(resultSet, all);
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return all;

    }

    public List<T> addSpecific(String[] par) {
        List<T> all = new ArrayList<>();
        try {
            Class.forName(databaseProperties.get("driver"));
            Connection connection = DriverManager.getConnection(
                    databaseProperties.get("connectionString"));
            PreparedStatement ps =
                    connection.prepareStatement(addQuery());
            for (int i=0; i< par.length; i++)
                ps.setNString(i+1, par[i]);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next())
                createListFromResultSet(resultSet, all);
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public List<T> removeSpecific(String[] par) {
        List<T> all = new ArrayList<>();
        try {
            Class.forName(databaseProperties.get("driver"));
            Connection connection = DriverManager.getConnection(
                    databaseProperties.get("connectionString"));
            PreparedStatement ps =
                    connection.prepareStatement(deleteQuery());
            for (int i=0; i< par.length; i++)
                ps.setNString(i+1, par[i]);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next())
                createListFromResultSet(resultSet, all);
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return all;
    }


    protected abstract void createListFromResultSet(ResultSet resultSet, List<T> all) throws SQLException;

    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }
}
