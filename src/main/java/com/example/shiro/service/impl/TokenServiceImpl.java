package com.example.shiro.service.impl;

import com.example.shiro.bean.Token;
import com.example.shiro.pojo.User;
import com.example.shiro.service.TokenService;
import com.example.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class TokenServiceImpl implements TokenService {
    private static final int Expire = 3600 * 25;
    private static HashMap<String, Token> poll = new HashMap<>();
    @Resource
    private UserService userService;

    @Override
    public User createToken(User user) {
        User user1 = userService.findByAccountAndPassword( user.getAccount(), user.getPassword() );
        //创建Token
        String token = UUID.randomUUID().toString();
        Date startTime = new Date();
        Date endTime = new Date( startTime.getTime() + Expire * 1000 );
        //写入数据库
        userService.insertToken( user1, token );
        //写入hashmap
        poll.put( user.getAccount(), new Token( token, startTime, endTime ) );
        return user1;
    }

    @Override
    public boolean isExpire(User user) {
        //
        if (null == user.getToken() || "".equals( user.getToken() ) || !poll.containsKey( user.getAccount() )) {
            return false;
        } else {
            Token token = poll.get( user.getAccount() );
            if (token.getEndTime().getTime()<new Date().getTime()){
                userService.deleteToken( user );
            }
        }
        return true;
    }
}
