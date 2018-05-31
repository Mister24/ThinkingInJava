/**
 * Fayuan.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.fayuan.basicjava.no001_Enum;

/**
 *
 * @author mr.24
 * @version $Id: Color.java, v 0.1 2018年01月21日 下午11:38 mr.24 Exp $
 */
public enum Color {

    RED("红色", 1),
    GREEN("绿色", 2),
    BLACK("白色", 3),
    YELLOW("黄色", 4);

    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //测试.values()方法
    public static String getName(int index) {
        for (Color color : Color.values()) {
            if (index == color.getIndex()) {
                return color.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}