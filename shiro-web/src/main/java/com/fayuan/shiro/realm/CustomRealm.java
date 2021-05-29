/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 自定义reaLm
 *
 * @author mr.24
 * @version Id: CustomRealm, v 1.0 2019/1/1 下午8:54 Exp $$
 */
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userInfo = new HashMap<>();
    {
        // 1ff1de774005f8da13f42943881c655f
        // d5e2fbef30a4eb668a203060ec8e5eef
        userInfo.put("mr.24", "d5e2fbef30a4eb668a203060ec8e5eef");
        userInfo.put("kobe", "24");
        userInfo.put("MJ", "23");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 1. 从主体传过来的认证信息中，获取用户名
        String userName = authenticationToken.getPrincipal().toString();

        // 2. 通过用户名访问数据库获取凭证
        String password = getPasswordByUserName(userName);

        if (null == password) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("mr.24", password, "defineRealm");

        // 加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("23"));

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 获取角色数据
        String userName = principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles = getRoleByUserName(userName);
        Set<String> permissions = getPermissionByUserName(userName);

        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.setRoles(roles);
        authenticationInfo.setStringPermissions(permissions);

        return authenticationInfo;
    }

    /**
     * 获取权限信息
     *
     * @param userName 用户名
     * @return         权限信息
     *
     * */
    private Set<String> getPermissionByUserName(String userName) {

        // 从数据库或缓存中获取
        Set<String> sets = new TreeSet<>();
        sets.add("user:delete");
        sets.add("user:add");

        return sets;
    }

    /**
     * 模拟数据库请求
     *
     * @param userName 用户名
     * @return
     *
     * */
    private Set<String> getRoleByUserName(String userName) {

        // 从数据库或缓存中获取
        Set<String> sets = new TreeSet<>();
        sets.add("admin");
        sets.add("user");

        return sets;
    }

    /**
     * 模拟数据库
     *
     * @param userName 用户名
     * @return         结果
     *
     * */
    private String getPasswordByUserName(String userName) {
        return userInfo.get(userName);
    }
}