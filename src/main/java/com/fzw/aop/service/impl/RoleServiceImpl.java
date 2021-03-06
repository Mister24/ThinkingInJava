/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.aop.service.impl;

import com.fzw.aop.pojo.Role;
import com.fzw.aop.service.RoleService;

/**
 * 服务实现类
 *
 * @author mr.24
 * @version Id: RoleServiceImpl, v 1.0 2019/3/19 上午1:42 Exp $$
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {
        System.out.println(role.toString());
    }
}
