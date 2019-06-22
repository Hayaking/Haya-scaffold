package com.example.shiro.service;

import com.example.shiro.pojo.Permission;

import java.util.List;

/**
 * @author haya
 */
public interface PermissionService {
    List<Permission> findRolePermissionList(int roleId);
}
