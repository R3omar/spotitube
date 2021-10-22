package com.re0mar.spotitube.presentation.login;

import com.re0mar.spotitube.Exceptions.Playlist.UserNotActiveException;
import com.re0mar.spotitube.Exceptions.login.UserNotFoundException;
import com.re0mar.spotitube.Logic.Login.UserCredDTO;
import com.re0mar.spotitube.presentation.login.UserDTO;

import java.util.ArrayList;
import java.util.Objects;

public interface IUserService {

    static ArrayList<UserCredDTO> tokenList = new ArrayList<UserCredDTO>();


    public UserCredDTO login(UserDTO user) throws UserNotFoundException;

    public UserCredDTO getActiveUser(String token);

}
