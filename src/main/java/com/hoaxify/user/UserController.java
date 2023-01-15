package com.hoaxify.user;

import com.hoaxify.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
   private static final Logger log = LoggerFactory.getLogger(UserController.class);
   @Autowired
   UserService userService;
    @PostMapping("/api/1.0/users")
    public Messages createUser(@RequestBody Users users){
        userService.SaveUser(users);
        return new Messages("User Created");
    }
}
