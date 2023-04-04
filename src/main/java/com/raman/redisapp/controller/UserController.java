package com.raman.redisapp.controller;

import com.raman.redisapp.entity.User;
import com.raman.redisapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/phone/{userId}")
    public String getUserContact(@PathVariable("userId") String userId) {
        return userService.getUserContact(userId);
    }

    @PostMapping(value = "/phone")
    public void updateUserContact(@RequestBody User user) {
        userService.updateUserContact(user.getUserId(), user.getPhone());
    }

    @PostMapping(value = "/phone/TTL")
    public void updateUserContactWithTTL(@RequestBody User user) {
        userService.updateUserContactWithTTL(user.getUserId(), user.getPhone());
    }
}
