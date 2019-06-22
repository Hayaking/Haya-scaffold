package com.example.shiro.bean.message;

import com.example.shiro.bean.message.impl.Message;
import com.example.shiro.bean.message.impl.PushMessage;

import static com.example.shiro.bean.message.BaseMessage.STATE;

/**
 * @author haya
 */
public class MessageFactory {
    public static BaseMessage message() {
        return new Message();
    }
    public static BaseMessage message(STATE state, String body) {
        return new Message(state,body);
    }
    public static BaseMessage PushMessage() {
        return new PushMessage();
    }
}
