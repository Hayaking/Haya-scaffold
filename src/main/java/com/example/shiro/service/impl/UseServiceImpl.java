package com.example.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shiro.mapper.UserMapper;
import com.example.shiro.pojo.User;
import com.example.shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UseServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq( "name", name );
        return userMapper.selectOne( wrapper );
    }

    @Override
    public User findByAccountAndPassword(String account, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq( "account", account )
                .eq( "password", password );
        return userMapper.selectOne( wrapper );
    }

    @Override
    public void insertToken(User user, String token) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set( "token", token );
        userMapper.update( user, wrapper );
        findByAccountAndPassword( user.getAccount(), user.getPassword() );
    }

    @Override
    public void deleteToken(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set( "token", null );
        userMapper.update(user, wrapper );
        findByAccountAndPassword( user.getAccount(), user.getPassword() );
    }
}
