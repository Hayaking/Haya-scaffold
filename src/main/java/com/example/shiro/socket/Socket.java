package com.example.shiro.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.example.shiro.socket.impl.UserListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author haya
 */
@Log4j2
@Service(value = "socket")
public class Socket {

    @Autowired
    private SocketIOServer socketIOServer;

    /**
     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
     */
    @PostConstruct
    private void autoStartup() {
        new UserListener().init( socketIOServer);
        socketIOServer.start();
        log.info( "Socket.IO已开启" );
    }

    @PreDestroy
    private void autoStop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
        log.info( "Socket.IO即将关闭" );
    }
}
