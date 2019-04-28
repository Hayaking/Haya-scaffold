package com.example.shiro.controller;

import com.example.shiro.pojo.User;
import com.example.shiro.service.TokenService;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user) {
        //如果用户带有有效的token
        if (tokenService.isExpire( user )) {
            return user;
        } else {
            User res = userService.findByAccountAndPassword( user.getAccount(), user.getPassword() );
            return res != null ? tokenService.createToken( res ) : null;
        }
    }
}
