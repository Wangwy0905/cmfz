package com.baizhi.Reaml;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.mapper.ShiroMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyReaml extends AuthorizingRealm {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ShiroMapper shiroMapper;
    @Override  //授权

    ////主体赋予 角色 权限   通过主体 查  角色   通过角色 查  权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = shiroMapper.queryRole(primaryPrincipal);

        List<Permission> permissions = shiroMapper.queryPermission(primaryPrincipal);

        if(roles!=null){
            for (int i = 0; i < roles.size(); i++) {
                authorizationInfo.addRole(roles.get(i).getName());

            }
            for (int i = 0; i <permissions.size(); i++) {

                authorizationInfo.addStringPermission(permissions.get(i).getPerm());

            }

            return authorizationInfo;

        }
        return null;

    }

    @Override   //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String principal = (String) authenticationToken.getPrincipal();
        Admin admin = new Admin();
        admin.setName(principal);
        Admin admin1 = adminMapper.selectOne(admin);

        if (admin1 != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin1.getName(), admin1.getPassword(), ByteSource.Util.bytes(admin1.getSalt()), this.getName());
            return authenticationInfo;
        }
        return null;
    }
}