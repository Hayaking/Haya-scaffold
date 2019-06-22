package com.example.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author haya
 */
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select role_id as id ,role_name from view_user_role where user_id = #{userId}")
    List<Role> findUserRoleList(@Param("userId") int userId);
}
