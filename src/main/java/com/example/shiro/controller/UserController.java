package com.example.shiro.controller;

import com.example.shiro.bean.message.MessageFactory;
import com.example.shiro.pojo.User;
import com.example.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shiro.bean.message.BaseMessage.STATE.FAILED;
import static com.example.shiro.bean.message.BaseMessage.STATE.SUCCESS;

/**
 * @author haya
 */
@RequestMapping("user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken( user.getId() + "", user.getUserPassword() );
        subject.login( token );
        boolean isLogin = subject.isAuthenticated();
        return isLogin
                ? MessageFactory.message( SUCCESS, (String) subject.getSession().getId() )
                : MessageFactory.message( FAILED, "" );
    }

    @RequiresPermissions( "删除用户" )
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(int id) {
        return userService.removeById( id );
    }
}
