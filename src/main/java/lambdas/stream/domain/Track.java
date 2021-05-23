/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package lambdas.stream.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 曲目
 *
 * @author mr.24
 * @version Id: Track, v 1.0 2018/12/31 上午10:13 Exp $$
 */
@Data
@Setter
@Getter
public class Track {
    /**
     * 名称
     */
    private String name;

    /**
     * 时长（毫秒）
     */
    private int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
