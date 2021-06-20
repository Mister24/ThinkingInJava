/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mr.24
 * @version Id: Dish, v 1.0 2021/6/20 4:26 下午 Exp $$
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    String name;
    boolean vegetarian;
    int calories;
    Type type;
}