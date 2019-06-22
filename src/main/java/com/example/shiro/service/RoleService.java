package com.example.shiro.service;

import com.example.shiro.pojo.Role;

import java.util.List;

/**
 * @author haya
 */
public interface RoleService {
    List<Role> findUserRole(int userId);
}
