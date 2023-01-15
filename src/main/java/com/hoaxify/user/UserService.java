package com.hoaxify.user;

import com.hoaxify.Messages;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    UserDao userDao;


    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    PasswordEncoder passwordEncoder;


    public Messages SaveUser(Users users){
        String encryptPass = this.passwordEncoder.encode(users.getPassword());
        users.setPassword(encryptPass);
        userDao.save(users);
        return new Messages("User Created");
    }
}
