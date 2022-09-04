package com.example.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public LoginLog checkUserData(UserEntity entity) {
        List<UserEntity> userUsingUsername = userRepo.findByUsername(entity.getUsername());

        LoginLog loginLog = new LoginLog();
        if (userUsingUsername.size() == 0) {
            loginLog.setOk(false);
            loginLog.setError("Invalid Username");
            loginLog.setExpected("ahmedheakl");
            loginLog.setFound(entity.getUsername());
            return loginLog;
        }
        UserEntity firstUser = userUsingUsername.get(0);
        String expected = firstUser.getPassword();
        String found = entity.getPassword();
        boolean comp = expected.equals(found);
        if (!comp) {
            loginLog.setOk(false);
            loginLog.setError("Invalid Password");
            loginLog.setExpected(firstUser.getPassword());
            loginLog.setFound(entity.getPassword());
            return loginLog;
        }

        return loginLog;
    }
}
