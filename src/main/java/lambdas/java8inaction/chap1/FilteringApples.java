/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap1;

import com.google.common.collect.Lists;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.fenum.qual.Fenum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author mr.24
 * @version Id: FilteringApples, v 1.0 2021/5/22 下午10:53 Exp $$
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        System.out.println(filter(inventory, FilteringApples::isGreenApple));

        System.out.println(filter(inventory, FilteringApples::isHeavyApple));

        System.out.println(filter(inventory, (Apple app) -> app.getWeight() < 100));

    }

    public static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> res = Lists.newArrayList();
        apples.forEach(
                apple ->
                {
                    if (predicate.test(apple)) {
                        res.add(apple);
                    }
                }
        );

        return res;
    }

    /**
     * 获取绿色
     *
     * @param inventory 库存
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 获取中重量大于150g的苹果
     *
     * @param inventory 库存
     * @return 结果
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return StringUtils.equals("green", apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }




    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Apple {
        private int weight;
        private String color;
    }
}
