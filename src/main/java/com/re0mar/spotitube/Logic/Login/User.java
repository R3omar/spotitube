package com.re0mar.spotitube.Logic.Login;

public class User {
    private int userId;
    private String userName;
    private String password;

    public User(int userId, String name, String password) {
        this.userId = userId;
        this.userName = name;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
