package com.example.shiro.service.impl;

import com.example.shiro.mapper.PermissionMapper;
import com.example.shiro.pojo.Permission;
import com.example.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findRolePermissionList(int roleId) {
        return permissionMapper.findPermissionList( roleId );
    }
}
