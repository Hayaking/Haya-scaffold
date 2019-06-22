package com.example.shiro.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author haya
 */
@Data
@TableName("permission")
public class Permission {
    @TableId
    private int id;
    @TableField("permissionName")
    private String permissionName;
}
