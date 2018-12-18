/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.shiro.defineRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mr.24
 * @version Id: DefineRealm, v 1.0 2018/12/19 上午1:45 Exp $$
 */
public class DefineRealm extends AuthorizingRealm {

    Map<String, String> userInfo = new HashMap<>();
    {
        userInfo.put("mr.24", "24");
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
