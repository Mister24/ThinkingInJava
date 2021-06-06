/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap4;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author mr.24
 * @version Id: ParallelStreamTest, v 1.0 2021/6/6 4:48 下午 Exp $$
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        long nowTime = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            streamTest();
        }
        long duration = System.currentTimeMillis() - nowTime;
        System.out.println(duration);

        long nowTime1 = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            parallelStreamTest();
        }
        long duration1 = System.currentTimeMillis() - nowTime1;
        System.out.println(duration1);

        System.out.println(duration - duration1);

    }

    public static void streamTest() {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        List<Integer> list2 = Lists.newArrayList();
        list.stream().forEach(
                list2::add
        );

//        System.out.println(list2);
    }

    public static void parallelStreamTest() {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        List<Integer> list2 = Lists.newCopyOnWriteArrayList();
        list.parallelStream().forEach(
                list2::add
        );

//        System.out.println(list2);
    }


}


















