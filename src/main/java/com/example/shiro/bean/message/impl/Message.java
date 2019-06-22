package com.example.shiro.bean.message.impl;

import com.example.shiro.bean.message.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author haya
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Message extends BaseMessage {
    STATE state;
    String body;

    public Message() {
    }

    public Message(STATE state, String body) {
        this.state = state;
        this.body = body;
    }
}
