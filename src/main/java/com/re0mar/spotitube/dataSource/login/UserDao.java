package com.re0mar.spotitube.dataSource.login;


import com.re0mar.spotitube.Logic.Login.IUserDao;
import com.re0mar.spotitube.dataSource.DatabaseProperties;
import com.re0mar.spotitube.dataSource.DAO;
import com.re0mar.spotitube.Logic.Login.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends DAO<User> implements IUserDao {

    public UserDao() {
        super(new DatabaseProperties());
    }


    @Override
    protected String query() {
        return "SELECT * FROM Users";
    }

    @Override
    protected String searchQuery() {
        return "SELECT * FROM Users WHERE userName = ? AND password = ?";
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
    public void createListFromResultSet(ResultSet resultSet, List<User> all) throws SQLException {
       all.add(new User(
               resultSet.getInt("userID"),
               resultSet.getString("userName"),
               resultSet.getString("password")
       ));
    }
}
