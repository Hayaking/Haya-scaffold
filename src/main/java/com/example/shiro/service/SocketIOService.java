package com.example.shiro.service;

public interface SocketIOService {
    String PUSH_EVENT = "push";
    void start() throws Exception;
    void stop();
}
