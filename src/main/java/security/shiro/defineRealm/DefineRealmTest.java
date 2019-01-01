/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.shiro.defineRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author mr.24
 * @version Id: DefineRealmTest, v 1.0 2018/12/19 上午1:59 Exp $$
 */
public class DefineRealmTest {
    @Test
    public void testAuthentication() {

        DefineRealm defineRealm = new DefineRealm();

        //1. 构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(defineRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        defineRealm.setCredentialsMatcher(matcher);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("mr.24", "24");

        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        subject.checkRoles("admin");

        subject.checkPermissions("user:delete", "user:add");

    }
}
