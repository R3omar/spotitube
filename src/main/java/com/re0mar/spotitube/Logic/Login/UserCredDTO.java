package com.re0mar.spotitube.Logic.Login;

public class UserCredDTO {
    private String token;
    private String user;
    private int userID;

    public UserCredDTO(String token, String user, int userID) {
        this.token = token;
        this.user = user;
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
