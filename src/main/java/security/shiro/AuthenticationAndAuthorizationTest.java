/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 认证和授权测试类
 *
 * @author mr.24
 * @version Id: AuthenticationAndAuthorizationTest, v 1.0 2018/12/16 下午8:41 Exp $$
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationAndAuthorizationTest {

    private SimpleAccountRealm simpleAccountRealm;

    @Before
    public void addUser() {
        simpleAccountRealm = new SimpleAccountRealm();
        // 添加主体权限
        simpleAccountRealm.addAccount("Mr.24", "24", "admin", "user");
    }

    @Test
    public void testAuthentication() {

        //1. 构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mr.24", "24");
        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        // 如果不是已经添加的账号密码，会抛出UnknownAccountException

        subject.logout();

        System.out.println("isAuthenticated : " + subject.isAuthenticated());
    }

    @Test
    public void testAuthorization() {

        //1. 构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mr.24", "24");
        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        // 校验主体权限
        subject.checkRoles("admin", "user");
    }
}
