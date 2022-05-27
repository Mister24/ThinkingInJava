/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.stream;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mr.24
 * @version Id: MapDemo, v 1.0 2018/12/31 上午12:14 Exp $$
 */
public class MapDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        List<String> collected = new ArrayList<>();

        for (String string : Arrays.asList("a", "b", "c")) {
            String upperCaseString = string.toUpperCase();
            collected.add(upperCaseString);
        }
        assertEquals(collected, Arrays.asList("A", "B", "C"));
    }

    @Test
    public void testMap() {
        List<String> collected = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(collected, Arrays.asList("A", "B", "C"));
    }
}
