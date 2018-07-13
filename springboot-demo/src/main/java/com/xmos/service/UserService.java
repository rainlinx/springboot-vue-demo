package com.xmos.service;

import com.xmos.constant.Constants;
import com.xmos.constant.ErrorCode;
import com.xmos.entity.User;
import com.xmos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(User user) {
        //先查询账号是否存在
        User user1 = userRepository.findByName(user);
        if (user1 == null) {
            return ErrorCode.WRONG_NAME;
        }
        //查询密码是否正确
        User user2 = userRepository.findByNameAndPassword(user);
        if (user2 != null) {
            return Constants.SUCCESS;
        } else {
            return ErrorCode.WRONG_PWD;
        }
    }

    public String register(User user) {
        //注册前先查询是否已注册
        User user1 = userRepository.findByName(user);
        if (user1 != null) {
            return ErrorCode.WRONG_NAME;
        }
        //注册
        int num = userRepository.addUser(user);
        if (num != 0) {
            return Constants.SUCCESS;
        } else {
            return ErrorCode.WRONG_NAME;
        }
    }

    public List<User> findUser(User user) {
        return userRepository.findUser(user);
    }
}
