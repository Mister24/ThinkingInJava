/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.threadlocalrandom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author mr.24
 * @version Id: DemoTest, v 1.0 2021/7/25 8:51 下午 Exp $$
 */
public class DemoTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1000));
        }

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(threadLocalRandom.nextInt(1000));
        }
    }
}
