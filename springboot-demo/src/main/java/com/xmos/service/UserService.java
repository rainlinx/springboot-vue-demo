package com.xmos.service;

import com.xmos.constant.Constants;
import com.xmos.constant.ErrorCode;
import com.xmos.entity.User;
import com.xmos.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String login(User user) {
        //先查询账号是否存在
        User user1 = userMapper.findByName(user);
        if (user1 == null) {
            return ErrorCode.WRONG_NAME;
        }
        //查询密码是否正确
        User user2 = userMapper.findByNameAndPassword(user);
        if (user2 != null) {
            return Constants.SUCCESS;
        } else {
            return ErrorCode.WRONG_PWD;
        }
    }

    public String register(User user) {
        //注册前先查询是否已注册
        User user1 = userMapper.findByName(user);
        if (user1 != null) {
            return ErrorCode.WRONG_NAME;
        }
        //注册
        int num = userMapper.addUser(user);
        if (num != 0) {
            return Constants.SUCCESS;
        } else {
            return ErrorCode.WRONG_NAME;
        }
    }

    public List<User> findUser(User user) {
        return userMapper.findUser(user);
    }

    public String updateUser(User user) {
        int rows = userMapper.updateUser(user);
        if (rows > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

    public String deleteUser(User user) {
        int rows = userMapper.deleteUser(user);
        if (rows > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
