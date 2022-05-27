/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package lambdas.java8inaction.chapter10_optional.domain.service;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

/**
 * @author mr.24
 * @version Id: OptionalTest, v 1.0 2019-10-29 00:28 Exp $$
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "true");
        properties.setProperty("c", "-3");

        //int res = Optional.ofNullable(properties.getProperty("a"))
          //      .flatMap(Optional)
        System.out.println(Optional.ofNullable(properties.getProperty("a")));
    }
}
