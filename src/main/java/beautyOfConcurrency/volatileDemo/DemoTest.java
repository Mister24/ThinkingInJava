/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package beautyOfConcurrency.volatileDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author mr.24
 * @version Id: DemoTest, v 1.0 2021/7/24 8:49 下午 Exp $$
 */
public class DemoTest {
    final static int MAX = 5;
    static volatile int initValue = 0;

    public static void main(String[] args) {

        // reader线程，当发现localValue和initValue不同的时候，则输出initValue被修改的信息
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                //启动reader线程，当发现localValue和initValue不一样时，输出START修改信息
                if (localValue != initValue) {
                    System.out.printf("the value is updated to [%d]\n", initValue);
                    // 对localValue进行重新复制
                    localValue = initValue;
                }
            }
        }, "reader").start();

        // update线程，对initValue进行修改，当localValue >= 5 的时候，退出生命周期
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX) {
                System.out.printf("the value will be updated to {%d}\n", ++localValue);
                initValue = localValue;
                try {
                    // 短暂休眠，为了让read线程来得及输出变化内容
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }, "updater").start();


    }
}
