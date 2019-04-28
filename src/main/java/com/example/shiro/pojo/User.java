package com.example.shiro.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private String account;
    private String name;
    private String password;
    private String token;
    private int role;
}
