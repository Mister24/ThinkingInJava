/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package security.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author mr.24
 * @version Id: JdbcRealmTest, v 1.0 2018/12/16 下午10:02 Exp $$
 */
public class JdbcRealmTest {
    @Test
    public void testAuthentication() {

        JdbcRealm jdbcRealm = new JdbcRealm();

        DruidDataSource dataSource = new DruidDataSource();

        {
            dataSource.setUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        }

        //1. 构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mr.24", "24");

        subject.login(token);

        System.out.println("isAuthenticated : " + subject.isAuthenticated());

    }
}
