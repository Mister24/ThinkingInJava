package swordOffer.no011;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 */

public class Solution {
    public int NumberOf1(int n) {

        String res;
        if (n == 0) {
            return 0;
        } else if ( n < 0) {
            res = Integer.toBinaryString(n);
        } else {
            res = n + "";
            char[] ch = res.toCharArray();
            ch[0] = '1';
        }

        return 0;
    }
}
