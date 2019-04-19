/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.basicjava.no004_InnerClass;

/**
 * 外部类与内部类
 *
 * @author mr.24
 * @version Id: Circle, v 1.0 2019-04-20 00:26 Exp $$
 */
public class Circle {

    private double radium = 0;

    public Circle(double radium) {
        this.radium = radium;
        getDrawInstance().draw();
    }

    class Draw {
        public void draw() {
            // 内部类可以直接访问外部类的变量或方法，即便是私有变量等
            System.out.println(radium);
        }
    }

    /**
     * 内部类的单例
     *
     * @return 内部类的实例化对象
     * */
    private Draw getDrawInstance() {
        return new Draw();
    }
}
