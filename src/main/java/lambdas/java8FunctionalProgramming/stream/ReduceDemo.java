/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.java8FunctionalProgramming.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author mr.24
 * @version Id: ReduceDemo, v 1.0 2018/12/31 上午10:36 Exp $$
 */
public class ReduceDemo {
    public static void main(String[] args) {

    }

    @Test
    public void testReduce() {
        int count = Stream.of(1, 2, 3)
                // (T identity, BinaryOperator<T> accumulator)
                .reduce(0, Integer::sum);

        Assert.assertEquals(6, count);
    }

}
