/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap4;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mr.24
 * @version Id: StreamTest, v 1.0 2021/6/5 4:06 下午 Exp $$
 */
public class StreamTest {
    public static void main(String[] args) {
        Dish fishDish = Dish.builder().name("fish").calories(100).build();
        Dish meatDish = Dish.builder().name("meat").calories(300).build();
        Dish potatoDish = Dish.builder().name("potato").calories(300).build();
        List<Dish> dishes = Lists.newArrayList(fishDish, meatDish, potatoDish);

        List<String> names = dishes.stream()
                .filter(dish -> dish.getCalories() > 100)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(
                names.stream()
                        .max(Comparator.comparing(String::length)).orElse("")
        );
    }
}

