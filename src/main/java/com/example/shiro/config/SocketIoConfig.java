package com.example.shiro.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocketIoConfig {
    @Value("${socketio.host:#{null}}")
    private String host;

    @Value("${socketio.port:#{null}}")
    private Integer port;

    @Value("${socketio.bossCount:#{null}}")
    private int bossCount;

    @Value("${socketio.workCount:#{null}}")
    private int workCount;

    @Value("${socketio.allowCustomRequests:#{null}}")
    private boolean allowCustomRequests;

    @Value("${socketio.upgradeTimeout:#{null}}")
    private int upgradeTimeout;

    @Value("${socketio.pingTimeout:#{null}}")
    private int pingTimeout;

    @Value("${socketio.pingInterval:#{null}}")
    private int pingInterval;

    @Bean
    public SocketIOServer socketIOServer() {
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        System.out.println(host);
        System.out.println(port);
        config.setSocketConfig(socketConfig);
        config.setHostname(host);
        config.setPort(port);
        config.setBossThreads(bossCount);
        config.setWorkerThreads(workCount);
        config.setAllowCustomRequests(allowCustomRequests);
        config.setUpgradeTimeout(upgradeTimeout);
        config.setPingTimeout(pingTimeout);
        config.setPingInterval(pingInterval);
        return new SocketIOServer(config);
    }
}
