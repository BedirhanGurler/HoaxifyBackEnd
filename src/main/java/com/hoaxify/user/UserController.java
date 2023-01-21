package com.hoaxify.user;

import com.hoaxify.Messages;
import com.hoaxify.error.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
public class UserController {
   private static final Logger log = LoggerFactory.getLogger(UserController.class);
   @Autowired
   UserService userService;
    @PostMapping("/api/1.0/users")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        String userName = users.getUsername();
        if(userName == null || userName.isEmpty()){
            ApiError error = new ApiError(400, "Validation Error", "/api/1.0/users");
            Map<String, String> validatinErrors = new HashMap<>();
            validatinErrors.put("username", "Username Cannot Be Null!");
            error.setValidationErrors(validatinErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        userService.SaveUser(users);
        return ResponseEntity.ok(new Messages("User Created"));
    }
}
