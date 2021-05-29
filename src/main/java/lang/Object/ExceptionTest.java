/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package lang.Object;

import org.junit.Test;

/**
 *
 * @author fzw.fzw
 * @version $Id: ExceptionTest.java, v 0.1 2018年06月17日 下午1:33 fzw.fzw Exp $
 */
public class ExceptionTest {

    public static void main(String[] args) {

        try {
            testNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("异常由上层进行处理");
        }
        //如果前面的代码中发生异常，后面的代码就不会执行
        System.out.println("调用成功");
    }

    public static void testNullPointerException() {

        int[] array = new int[10];
        array = null;
        //由于执行者不处理异常，异常会自动抛出
        int length = array.length;
        System.out.println(length);
    }

    @Test
    public void testArithmeticException() {
        try {
            int result = 10 / 0;
            System.out.println("try中异常之后的代码不会执行");
        } catch (ArithmeticException e) {
            System.out.println("进行异常处理：");
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("异常：" + e.toString());
        }
        System.out.println("try...catch之后的代码可以执行");
    }
}