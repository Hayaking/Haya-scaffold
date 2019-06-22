package com.example.shiro.config.shiro;

import com.example.shiro.pojo.Permission;
import com.example.shiro.pojo.Role;
import com.example.shiro.pojo.User;
import com.example.shiro.service.PermissionService;
import com.example.shiro.service.RoleService;
import com.example.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haya
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 登录成功后 获取角色、权限等信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) getAvailablePrincipal( principalCollection );
        Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roleList = roleService.findUserRole( user.getId() );
        for (Role item : roleList) {
            roles.add( item.getRoleName() );
            List<Permission> permissionList = permissionService.findRolePermissionList( item.getId() );
            for (Permission item2 : permissionList) {
                info.addStringPermission( item2.getPermissionName() );
            }
        }
        info.setRoles( roles );

        return info;
    }

    /**
     * 登录验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //拿到账号
        int id = Integer.parseInt( (String) token.getPrincipal() );
        //拿到密码
        String passWord = new String( (char[]) token.getCredentials() );
        User user = userService.find( id, passWord );
        return new SimpleAuthenticationInfo( user, user.getUserPassword(), getName() );
    }
}
