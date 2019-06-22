package com.example.shiro.socket.impl;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.shiro.bean.message.impl.PushMessage;
import com.example.shiro.socket.Listener;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.UUID;

/**
 * @author haya
 */
@Log4j2
public class UserListener implements Listener {
    private final String ROUT_MSG_TO_SERVER = "rout_msg_to_server";
    private final String ROUT_MSG_TO_CLIENT = "rout_msg_to_client";
    private final String ROUT_MSG_TO_SELF = "rout_msg_to_self";
    private final String LOGIN_AFTER = "login_after";


    @Override
    public void init(SocketIOServer socketIOServer) {

        // 监听客户端连接
        socketIOServer.addConnectListener( client -> {
            UUID uuid = client.getSessionId();
            log.info( "uuid:" + uuid + "已连接" );
        } );

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener( client -> {
            UUID uuid = client.getSessionId();
            log.info( "uuid:" + uuid + "已断开" );
        } );
        /*
         * 客户端发送路由消息给服务器
         */
        socketIOServer.addEventListener( ROUT_MSG_TO_SERVER, PushMessage.class, (client, data, ackSender) -> {

        } );
        /*
         *客户端消息路由给自己
         */
        socketIOServer.addEventListener( ROUT_MSG_TO_SELF, PushMessage.class, (client, data, ackSender) -> {
           
        } );
        /*
         * 登陆成功后发送的消息
         * 用于将 account-sessionId注册到poll里
         */
        socketIOServer.addEventListener( LOGIN_AFTER, PushMessage.class, (client, data, ackSender) -> {

        } );
    }

}
