/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mr.24
 * @version Id: FlapmapDemo, v 1.0 2018/12/31 上午10:01 Exp $$
 */
public class FlapmapDemo {
    public static void main(String[] args) {

    }

    @Test
    public void testFlapMap() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);

        List<Integer> together = Stream.of(list, list1)
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        list.add(3);
        list.add(4);
        Assert.assertEquals(list, together);
    }
}
