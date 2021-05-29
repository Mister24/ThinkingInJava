/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.basicjava.version8;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author fzw.fzw
 * @version $Id: StreamTech.java, v 0.1 2018年06月28日 下午4:53 fzw.fzw Exp $
 */
public class StreamTech {

    public static void main(String[] args) {

    }

    @Test
    public void testArrayToStream() {

        String[] citys = {"beijing", "shanghai", "guangzhou", "shenzhen", "hangzhou"};
        Stream<String> cityStream = Arrays.stream(citys);
    }

    @Test
    public void testFilterCount() {
        String[] citys = {"beijing", "shanghai", "shanghai", "guangzhou", "shenzhen", "hangzhou"};
        Stream<String> cityStream = Arrays.stream(citys);
        //int count = cityStream.
    }
}