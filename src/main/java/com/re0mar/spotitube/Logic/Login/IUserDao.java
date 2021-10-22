package com.re0mar.spotitube.Logic.Login;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();

    public List<User> findSpecific(String[] par);

    public List<User> addSpecific(String[] par);

    public List<User> removeSpecific(String[] par);
}
