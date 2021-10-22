package com.re0mar.spotitube.Logic.Login;

import com.re0mar.spotitube.Exceptions.Playlist.UserNotActiveException;
import com.re0mar.spotitube.Exceptions.login.UserNotFoundException;
import com.re0mar.spotitube.presentation.login.IUserService;
import com.re0mar.spotitube.presentation.login.UserDTO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class UserService implements IUserService {

    @Inject
    private IUserDao userDao;

    @Override
    public UserCredDTO login(UserDTO u) throws UserNotFoundException {
        if (u.getUser() == null || u.getPassword() == null) throw new UserNotFoundException();

        List<User> users = userDao.findSpecific(new String[]{u.getUser(), DigestUtils.sha256Hex(u.getPassword())});

        if (users.size() < 1) throw new UserNotFoundException();

        UserCredDTO res = new UserCredDTO(UUID.randomUUID().toString(), users.get(0).getUserName(), users.get(0).getUserId());
        tokenList.add(res);
        return res;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public UserCredDTO getActiveUser(String token) {
        UserCredDTO res = null;

        for (UserCredDTO u: tokenList) {
            if(Objects.equals(token, u.getToken())) res = u;
        }

        if(res == null) throw new UserNotActiveException();

        return res;
    }
}

