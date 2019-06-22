package com.example.shiro.service.impl;

import com.example.shiro.mapper.RoleMapper;
import com.example.shiro.pojo.Role;
import com.example.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findUserRole(int userId) {
        return roleMapper.findUserRoleList( userId );
    }

}
