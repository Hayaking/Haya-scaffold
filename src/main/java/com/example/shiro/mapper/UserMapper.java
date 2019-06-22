package com.example.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author haya
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select id,user_name,user_password from user where id = #{id} and user_password = #{password}")
    User findByIdPassword(@Param( "id" ) int id, @Param("password") String password);

}
