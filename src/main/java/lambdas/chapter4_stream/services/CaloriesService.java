/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package lambdas.chapter4_stream.services;

import lambdas.chapter4_stream.domain.Dish;

import java.util.List;

/**
 * 服务类
 *
 * @author mr.24
 * @version Id: CaloriesService, v 1.0 2019-10-26 15:49 Exp $$
 */
public interface CaloriesService {

    /**
     * 获取热量最高的三种菜品
     *
     * @param dishList
     * @return
     */
    List<String> getTopNCoriesDishs(List<Dish> dishList);
}
