package com.example.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shiro.pojo.User;

public interface UserService extends IService<User> {
    User findByName(String name);

    User findByAccountAndPassword(String account, String password);

    void insertToken(User user, String token);

    void deleteToken(User user);
}
