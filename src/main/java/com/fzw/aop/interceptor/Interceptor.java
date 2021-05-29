/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.aop.interceptor;

/**
 * 拦截器
 *
 * @author mr.24
 * @version Id: Interceptor, v 1.0 2019/3/19 上午1:31 Exp $$
 */
public interface Interceptor {

    public void before(Object obj);

    public void after(Object obj);

    public void afterReturning(Object obj);

    public void afterThrowing(Object obj);
}
