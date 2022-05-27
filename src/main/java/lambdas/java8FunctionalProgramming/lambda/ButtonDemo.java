/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.lambda;

import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author fzw.fzw
 * @version $Id: ButtonDemo.java, v 0.1 2018年10月20日 下午9:58 fzw.fzw Exp $
 */
public class ButtonDemo {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked.");
            }
        });
    }

    /**
     *  javac 根据程序的上下文(addActionListener 方法的签名)在后台推断出了参数 event 的类型。
     *  这意味着如果参数类型不言而明，则无需显式指定。
     * */
    @Test
    public void test() {
//        Button button = new Button();
//        button.addActionListener(event -> System.out.println("button clicked."));
//
        final int num = 0;
        Runnable runnable = () -> System.out.println(num);
        runnable.run();
        
        int num1 = 2;
        Runnable runnable1 = () -> System.out.println(num1 + 1);
        runnable1.run();

        ArrayList list = new ArrayList();
        list.add(1);
        Runnable runnable2 = () -> {
            list.add(3);
            System.out.println(list);

        };
        runnable2.run();

    }
}