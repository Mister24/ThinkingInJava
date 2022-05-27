/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.stream;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author mr.24
 * @version $Id: StreamDemo.java, v 0.1 2018年10月21日 上午10:50 fzw.fzw Exp $
 */
public class StreamDemo {
    public static void main(String[] args) {

    }

    @Test
    public static void collectTest() {

        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);

    }
}