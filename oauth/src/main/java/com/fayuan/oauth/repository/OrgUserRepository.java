/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.oauth.repository;

import com.fayuan.oauth.entity.UserOrganization;
import org.springframework.data.repository.CrudRepository;

/**
 * 数据库操作
 *
 * @author mr.24
 * @version Id: OrgUserRepository, v 1.0 2019-04-21 23:39 Exp $$
 */
public interface OrgUserRepository extends CrudRepository<UserOrganization, String> {
    public UserOrganization findByUserName(String userName);
}
