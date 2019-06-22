package com.example.shiro.config.exception;

import com.example.shiro.bean.message.MessageFactory;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.shiro.bean.message.BaseMessage.STATE.FAILED;

/**
 * @author haya
 */
@Log4j2
@ControllerAdvice
@ResponseBody
public class ExceptionFilter {

    /**
     * 拦截shiro抛出的无权限异常
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object unauthorizedException() {
        return MessageFactory.message( FAILED, "权限不足" );
    }

    /**
     * 未登录报错拦截
     * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
     * @return
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public Object unauthenticatedException() {
        return MessageFactory.message( FAILED, "未登录" );
    }

    /**
     * 拦截所有优先级比自己低的异常
     * 同一个类下 拦截的异常越准确 优先级越高
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object defaultErrorHandler(Exception e) {
//        e.getMessage();
        return MessageFactory.message( FAILED, "系统异常" );
    }
}
