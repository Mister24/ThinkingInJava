/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.aop;

import com.fayuan.aop.interceptor.Interceptor;

/**
 * 代理工厂类
 *
 * <>bean必须是一个实现了某一个接口的对象</>
 * <>最先会执行Interceptor的before方法</>
 * <>其次通过反射执行bean的方法</>
 * <>执行bean的方法，无论是否返回异常，都会执行after方法</>
 * <>执行bean方法时，如果不产生异常，则执行afterReturning方法，如果产生异常，则执行afterThrowing方法</>
 * <></>
 *
 * @author mr.24
 * @version Id: ProxyBeanFactory, v 1.0 2019/3/19 上午1:33 Exp $$
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj, Interceptor interceptor) {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}
