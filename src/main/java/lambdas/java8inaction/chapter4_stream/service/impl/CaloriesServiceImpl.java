/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package lambdas.java8inaction.chapter4_stream.service.impl;

import lambdas.java8inaction.chapter4_stream.domain.Dish;
import lambdas.java8inaction.chapter4_stream.service.CaloriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现类
 *
 * @author mr.24
 * @version Id: CaloriesServiceImpl, v 1.0 2019-10-26 15:51 Exp $$
 */
@Service
public class CaloriesServiceImpl implements CaloriesService {
    @Override
    public List<String> getTopNCoriesDishs(List<Dish> dishList) {
        return dishList.stream()
                .filter(c -> c.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
