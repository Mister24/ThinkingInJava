/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.domain;

import lombok.Data;

/**
 * 用户类
 *
 * @author mr.24
 * @version Id: User, v 1.0 2019/1/1 下午10:58 Exp $$
 */
@Data
public class User {
    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
