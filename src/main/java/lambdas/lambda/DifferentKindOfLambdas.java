/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package lambdas.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * 指明lambda表达式的几种使用方法
 *
 * @author fzw.fzw
 * @version $Id: DifferentKindOfLambdas.java, v 0.1 2018年10月20日 下午10:05 fzw.fzw Exp $
 */
public class DifferentKindOfLambdas {

    public static void main(String[] args) {

        // 方法一：所示的 Lambda 表达式不包含参数，使用空括号 () 表示没有参数。
        Runnable runnable = () -> System.out.println("123");

        // 方法二：所示的 Lambda 表达式包含且只包含一个参数，可省略参数的括号
        ActionListener actionListener = e -> System.out.println("123");

        // 方法三：表达式的主体不仅可以是一个表达式，而且也可以是一段代码块，使用大括号 ({})将代码块括起来
        // 只有一行代码的 Lambda 表达式也可使用大括号，用以明确 Lambda表达式从何处开始、到哪里结束
        Runnable run = () -> {
            System.out.println("123");
            System.out.println("234");
        };

        // 方法四：Lambda 表达式也可以表示包含多个参数的方法，
        // 参数类型都是由编译器推断得出的。
        // 但有时最好也可以显式声明参数类型，此时就需要使用小括号将参数括起来，
        BinaryOperator<Long> add = (x, y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }
}