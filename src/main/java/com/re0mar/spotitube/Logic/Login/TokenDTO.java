package com.re0mar.spotitube.Logic.Login;

public class TokenDTO {
    private String token;
    private String owner;

    public TokenDTO(String token, String owner) {
        this.token = token;
        this.owner = owner;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
