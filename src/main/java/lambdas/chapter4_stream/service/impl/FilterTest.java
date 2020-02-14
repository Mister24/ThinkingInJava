/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package lambdas.chapter4_stream.services.impl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author mr.24
 * @version Id: FilterTest, v 1.0 2019-10-26 20:37 Exp $$
 */
public class FilterTest {
    @Test
    public void testFilter() {
        List<String> list = Arrays.asList("java8", "in", "action");
        list.stream().forEach(s -> System.out.println(s));

        Stream stream = list.stream();
        stream.forEach(System.out::println);
    }
}
