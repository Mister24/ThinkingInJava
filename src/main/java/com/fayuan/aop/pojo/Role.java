/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.aop.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色类
 *
 * @author mr.24
 * @version Id: Role, v 1.0 2019/3/19 上午1:41 Exp $$
 */
@Data
public class Role implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3076575231031524882L;

    /** id */
    private Long id;

    /** 角色名称 */
    private String roleName;

    /** 备注 */
    private String note;

    public Role() {
    }

    public Role(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
