/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2021 All Rights Reserved.
 */
package lambdas.java8inaction.chap2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mr.24
 * @version Id: User, v 1.0 2021/5/30 12:23 上午 Exp $$
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -7490833124692087184L;

    String name;

    String country;
}
