/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap5;

import lambdas.java8inaction.chap4.Dish;
import lambdas.java8inaction.chap4.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mr.24
 * @version Id: StreamTest, v 1.0 2021/6/20 4:20 下午 Exp $$
 */
public class StreamTest {
    // menu
    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));


    public static void main(String[] args) {

        // Filtering with predicate
        List<Dish> vegetarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());
        vegetarianMenu.forEach(System.out::println);

        // 去重
        List<Integer> numbers = Arrays.asList(1,2,1,2,3,2,3,2,5,4,4);
        List<Integer> res = numbers.stream().distinct()
                .collect(Collectors.toList());
        System.out.println(res);

        // Truncating a stream
        List<Dish> dishesLimit3 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(Collectors.toList());

        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(Collectors.toList());
    }


}
