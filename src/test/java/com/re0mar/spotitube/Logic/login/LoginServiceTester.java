package com.re0mar.spotitube.Logic.login;

import com.re0mar.spotitube.Exceptions.login.UserNotFoundException;
import com.re0mar.spotitube.Logic.Login.User;
import com.re0mar.spotitube.Logic.Login.UserCredDTO;
import com.re0mar.spotitube.Logic.Login.UserService;
import com.re0mar.spotitube.dataSource.login.UserDao;
import com.re0mar.spotitube.presentation.login.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class LoginServiceTester {

    private UserService sut;
    private UserDao mock;

    @BeforeEach
    public void setup() {
        this.sut = new UserService();
        this.mock = Mockito.mock(UserDao.class);

        sut.setUserDao(mock);
    }

    @Test
    public void ServiceCallsFindSpecific() {
        var user = new UserDTO();
        user.setUser("admin");
        user.setPassword("password");

        var res = new ArrayList<User>();
        res.add(new User(0, "admin", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"));

        Mockito.when(mock.findSpecific(any(String[].class))).thenReturn(res);

        sut.login(user);

        Mockito.verify(mock).findSpecific(any(String[].class));

    }

//    @Test
//    public void ServiceTrowsExceptionWithEmptyUser() throws UserNotFoundException {
//        var val = new UserDTO();
//        UserCredDTO i;
//
//        assertThrows(UserNotFoundException.class, (Executable) (sut.login(val)));
//    }


}
