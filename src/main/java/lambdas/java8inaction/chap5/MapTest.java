/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mr.24
 * @version Id: MapTest, v 1.0 2021/6/26 10:53 下午 Exp $$
 */
public class MapTest {
    public static void main(String[] args) {
    }

    @Test
    public void testMap() {
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
    }
}
