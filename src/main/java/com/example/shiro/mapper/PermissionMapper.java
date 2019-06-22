package com.example.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author haya
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("select permission_id as id,permission_name from view_role_permission where role_id = #{roleId}")
    List<Permission> findPermissionList(int roleId);
}
