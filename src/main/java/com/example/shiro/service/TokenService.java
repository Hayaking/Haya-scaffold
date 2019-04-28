package com.example.shiro.service;

import com.example.shiro.pojo.User;

public interface TokenService {
    User createToken(User user);

    boolean isExpire(User user);
}
