package com.xmos.controller;

import com.xmos.entity.User;
import com.xmos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/findUser")
    public List<User> findUser(@RequestBody User user) {
        return userService.findUser(user);
    }
}
