/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fzw.basicjava.no004_InnerClass;

/**
 * @author mr.24
 * @version Id: InnerClassTest, v 1.0 2019-04-20 00:30 Exp $$
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        //
        Outer.Inner inner1 = outer.getInnerInstance();
    }
}
