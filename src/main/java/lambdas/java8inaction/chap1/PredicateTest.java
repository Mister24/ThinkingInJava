/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap1;

import com.google.common.collect.Lists;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author mr.24
 * @version Id: PredicateTest, v 1.0 2021/5/23 12:17 下午 Exp $$
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate predicate = o -> !CollectionUtils.isEmpty((List) o);
        Assert.isTrue(predicate.test(Lists.newArrayList("1")));
    }
}
