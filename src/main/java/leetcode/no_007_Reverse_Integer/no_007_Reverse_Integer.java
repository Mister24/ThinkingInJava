/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package leetcode.no_007_Reverse_Integer;

/**
 * @author mr.24
 * @version Id: no_007_Reverse_Integer, v 1.0 2019/3/7 下午10:36 Exp $$
 */
public class no_007_Reverse_Integer {
    public static void main(String[] args) {

        System.out.println(reverse(123));
        System.out.println("#############");
        System.out.println(reverse(-123));
        System.out.println("#############");
        System.out.println(reverse(120));
        System.out.println("#############");
        //System.out.println(reverse(9646324351));
    }

    public static int reverse(int x) {

        // 1. 为0
        if (x == 0) {
            return 0;
        }
        // 2. 正数
        if (x > 0) {
            String str = String.valueOf(x);
            int len = str.length();
            // 结尾是否为0
            int actualLength = (x % 10 == 0) ? len - 1 : len;
            str = (x % 10 == 0) ? str.substring(0, actualLength - 1) : str;

            char[] chars = str.toCharArray();
            for (int i = 0; i < actualLength / 2; i++) {
                char tem = chars[i];
                chars[i] = chars[actualLength - 1 - i];
                chars[actualLength - 1 - i] = tem;
            }

            return Integer.parseInt(String.valueOf(chars));
        } else {
            // 3. 负数
            // 3.1 先去符号
            String str = String.valueOf(x).substring(1);
            int len = str.length();
            // 结尾是否为0
            int actualLength = (x % 10 == 0) ? len - 1 : len;

            char[] chars = str.toCharArray();
            for (int i = 0; i < actualLength / 2; i++) {
                char tem = chars[i];
                chars[i] = chars[actualLength - 1 - i];
                chars[actualLength - 1 - i] = tem;
            }

            return (0 - Integer.parseInt(String.valueOf(chars)));
        }
    }
}
