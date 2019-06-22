package com.example.shiro.bean.message.impl;

import com.example.shiro.bean.message.BaseMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author haya
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PushMessage extends BaseMessage {
    private String account;
    private String token;
    private String to;
    private String type;
    private String body;
}
