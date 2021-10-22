package com.re0mar.spotitube.presentation.login;

import com.re0mar.spotitube.Exceptions.login.UserNotFoundException;
import com.re0mar.spotitube.Logic.Login.UserCredDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

public class LoginHandlerTester {

    private LoginResource sut;
    private IUserService mock;

    @BeforeEach
    public void setup() {
        sut = new LoginResource();

        this.mock = Mockito.mock(IUserService.class);

        sut.setUserService(mock);
    }

    @Test
    public void callsLogicLoginFunction() throws UserNotFoundException {
        var user = new UserDTO();

        UserCredDTO val = new UserCredDTO("dc96e1d9-c741-4ea3-8e40-d0f6f76a8188", "admin", 0);

        Mockito.when(mock.login(new UserDTO())).thenReturn(val);

        Response act = sut.loginCheck(user);

        assertEquals(val, act.getEntity());
    }






}
