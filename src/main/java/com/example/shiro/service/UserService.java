package com.example.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shiro.pojo.User;

/**
 * @author haya
 */
public interface UserService extends IService<User> {
    User find(int id);

    User find(int id, String password);

}
