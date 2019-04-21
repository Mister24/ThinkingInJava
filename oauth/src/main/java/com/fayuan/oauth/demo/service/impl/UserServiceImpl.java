/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.oauth.demo.service.impl;

import com.fayuan.oauth.demo.entity.User;
import com.fayuan.oauth.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author mr.24
 * @version Id: UserServiceImpl, v 1.0 2019-04-20 23:31 Exp $$
 */
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User create(User user) {
        String hash = encoder.encode(user.get)
        return null;
    }
}
