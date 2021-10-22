package com.re0mar.spotitube.presentation.login;

public class TokenDTO {
    private String user;
    private int token;

    public TokenDTO(int token, String user) {
        this.user = user;
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
