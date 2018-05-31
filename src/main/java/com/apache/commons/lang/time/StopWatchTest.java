/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.apache.commons.lang.time;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author fayuan.fzw
 * @version $Id: StopWatchTest.java, v 0.1 2018年05月29日 下午6:05 fayuan.fzw Exp $
 */
public class StopWatchTest {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        System.out.println("123");

        stopWatch.stop();

        System.out.println(stopWatch.getNanoTime());
    }
}