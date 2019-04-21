/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.oauth.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 失败处理器
 *
 * @author mr.24
 * @version Id: MyAuthenticationFailHandler, v 1.0 2019-04-20 23:10 Exp $$
 */
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

    /** logger */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        response.setStatus(500);
        response.setContentType("application/json;charset=UTF-8");

        //将登录失败信息打包成json格式返回
        response.getWriter().write(exception.getMessage());
    }
}
