package com.example.shiro.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Token {
    private String token;
    private Date startTime;
    private Date endTime;

    public Token(String token, Date startTime, Date endTime) {
        this.token = token;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
