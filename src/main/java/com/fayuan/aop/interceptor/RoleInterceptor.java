/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.aop.interceptor;

/**
 * 角色拦截器
 *
 * @author mr.24
 * @version Id: RoleInterceptor, v 1.0 2019/3/19 上午1:50 Exp $$
 */
public class RoleInterceptor implements Interceptor {
    @Override
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object obj) {
        System.out.println("打印完成");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("完成打印，正常.");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("打印出现异常情况.");
    }
}
