/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * OAuth2启动类
 *
 * @author mr.24
 * @version Id: Oauth2Application, v 1.0 2019-04-20 15:40 Exp $$
 */
@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@RestController
public class Oauth2Application {
    @RequestMapping(value = {"/user"}, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();

        userInfo.put(
                "user",
                user.getUserAuthentication().getPrincipal()
        );

        userInfo.put(
                "authorities",
                AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities())
        );

        return userInfo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }
}
