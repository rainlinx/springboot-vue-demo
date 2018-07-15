package com.xmos.controller;

import com.xmos.controller.param.Params;
import com.xmos.entity.User;
import com.xmos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //查询用户
    @PostMapping("/findUser")
    public List<User> findUser(@RequestBody User user) {
        return userService.findUser(user);
    }

    //注册用户
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    //修改用户
    @PostMapping("/alterUser")
    public String AlterUser(@RequestBody Params params) {
        if ("update".equals(params.getOperations())) {
            return userService.updateUser(params.getUser());
        } else if ("delete".equals(params.getOperations())) {
            return userService.deleteUser(params.getUser());
        } else {
            return "操作有误";
        }
    }
}
