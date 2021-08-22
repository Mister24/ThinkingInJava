/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.stream;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mr.24
 * @version Id: FilterDemo, v 1.0 2018/12/31 上午12:42 Exp $$
 */
public class FilterDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String str : Arrays.asList("a", "b", "12")) {
            if (Character.isDigit(str.charAt(0))) {
                beginningWithNumbers.add(str);
            }
        }

        assertEquals(beginningWithNumbers, Arrays.asList("12"));
    }

    @Test
    public void testFilter() {
        List<String> beginningWithNumbers = Stream.of("a", "b", "12")
                .filter(str -> Character.isDigit(str.charAt(0)))
                .collect(Collectors.toList());
        assertEquals(beginningWithNumbers, Arrays.asList("12"));
    }
}
