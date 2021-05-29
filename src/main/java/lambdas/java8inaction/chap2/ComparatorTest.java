/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap2;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * @author mr.24
 * @version Id: ComparatorTest, v 1.0 2021/5/30 12:14 上午 Exp $$
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();

        stringList.add("bc");
        stringList.add("a");
        stringList.add("b");
        stringList.add("bd");
        stringList.add("c");

        System.out.println(stringList);
        stringList.sort(String::compareTo);
        System.out.println(stringList);
        stringList.sort(Comparator.reverseOrder());
        System.out.println(stringList);
        stringList.sort(Comparator.naturalOrder());
        System.out.println(stringList);

        stringList.stream()
                .findAny()
                .ifPresent(System.out::println);

        stringList.stream()
                .findFirst()
                .map(t -> {
                    return t.toUpperCase(Locale.ROOT) + "BC";
                })
                .ifPresent(
                        System.out::println
                );
    }


    @Test
    public void test() {

        User user1 = User.builder().name("a").country("China").build();
        User user2 = User.builder().name("b").country("China").build();
        User user3 = User.builder().name("c").country("USA").build();

        List<User> users = Lists.newArrayList(user1, user2, user3);

        users.sort(
                Comparator.comparing(User::getCountry)
                        .reversed().thenComparing(User::getName)
                        .thenComparing(User::hashCode)
        );

        System.out.println(users);
    }
}
