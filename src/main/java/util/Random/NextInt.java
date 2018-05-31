/**
 * fayuan.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package util.Random;

import java.util.Random;

/**
 * 测试Random.nextInt()方法
 *
 * @author fayuan.fzw
 * @version $Id: NextInt.java, v 0.1 2018年02月17日 下午8:33 fayuan.fzw Exp $
 */
public class NextInt {
    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(20);
        System.out.println(number);
    }
}