/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.oauth.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户类
 *
 * @author mr.24
 * @version Id: UserOrganization, v 1.0 2019-04-21 23:36 Exp $$
 */
public class UserOrganization implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 773256279808092484L;

    @Column(name = "origanization_id", nullable = false)
    String origanizationId;

    @Id
    @Column(name = "user_name", nullable = false)
    String userName;

    /**
     * Getter method for property <tt>origanizationId</tt>.
     *
     * @return property value of origanizationId
     */
    public String getOriganizationId() {
        return origanizationId;
    }

    /**
     * Setter method for property <tt>origanizationId</tt>.
     *
     * @param origanizationId value to be assigned to property origanizationId
     */
    public void setOriganizationId(String origanizationId) {
        this.origanizationId = origanizationId;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
