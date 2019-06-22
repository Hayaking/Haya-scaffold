package com.example.shiro.socket;

import com.corundumstudio.socketio.SocketIOServer;

import java.util.Map;
import java.util.UUID;

/**
 * @author haya
 */
public interface Listener {
     void init(SocketIOServer socketIOServer);
}
