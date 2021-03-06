/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * OAuth配置
 *
 * @author mr.24
 * @version Id: OAuthSecurityConfig, v 1.0 2019-04-20 20:54 Exp $$
 */
@Configuration
public class OAuthSecurityConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager        authenticationManager;

    @Autowired
    private UserDetailsService           userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    //配置客户端认证
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用in-memory存储
        clients.inMemory()
                // clientId
                .withClient("eagleeye")
                // clientSecret
                .secret("thisissecret")
                // 该client允许的授权类型
                .authorizedGrantTypes(
                        "refresh_token",
                        "password",
                        "client_credentials")
                // 该client允许的授权范围
                .scopes("webclient", "mobileclient");
    }


    //配置token的数据源、自定义的tokenServices等信息
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager)
//                .tokenStore(tokenStore(dataSource))
//                .tokenServices(authorizationServerTokenServices())
//                .accessTokenConverter(accessTokenConverter())
//                .exceptionTranslator(webResponseExceptionTranslator);
//    }

//    XmlBeanFactory xmlBeanFactory = new XmlBeanFactory()


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }


}
