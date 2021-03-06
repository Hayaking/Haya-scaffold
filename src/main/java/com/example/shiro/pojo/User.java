package com.example.shiro.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author haya
 */
@Data
@TableName("user")
public class User {
    @TableId
    private int id;
    @TableField("user_name")
    private String userName;
    @TableField("user_password")
    private String userPassword;
}
