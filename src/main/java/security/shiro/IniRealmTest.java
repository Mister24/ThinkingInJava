/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * IniRealm测试类
 *
 * @author mr.24
 * @version Id: IniRealmTest, v 1.0 2018/12/16 下午9:50 Exp $$
 */
public class IniRealmTest {
    @Test
    public void testAuthentication() {

        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        //1. 构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mr.24", "24");

        // org.apache.shiro.authc.UnknownAccountException:
        // Realm [org.apache.shiro.realm.text.IniRealm@523884b2] was unable to find account data for the submitted AuthenticationToken [org.apache.shiro.authc.UsernamePasswordToken - Mr.214, rememberMe=false].
        // UsernamePasswordToken tokenWithWrongName = new UsernamePasswordToken("Mr.23", "24");

        // org.apache.shiro.authc.IncorrectCredentialsException:
        // Submitted credentials for token [org.apache.shiro.authc.UsernamePasswordToken - Mr.24, rememberMe=false] did not match the expected credentials.
        //UsernamePasswordToken tokenWithWrongPasswd = new UsernamePasswordToken("Mr.24", "23");

        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

        // 角色校验
        subject.checkRole("admin");

        // 权限校验
        subject.checkPermission("user:delete");
        subject.checkPermission("user:update");
    }
}
