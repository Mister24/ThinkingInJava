package swordOffer.no010;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * */
public class Solution {

    /**
     * 设 2*n 的大矩形有F(n)种被覆盖方法。
     * 1）当n = 0时，大矩形为空，显然F(0) = 0；
     * 2）当n = 1时，大矩形与小矩形规格相同，F(1) = 1；
     * 3）当n = 2时，使用2个小矩形可覆盖大矩形，但横竖摆放各有1种方法，故F(2) = 2；
     * 4）当n > 2时，覆盖方法可分为两大类：
     *      1.先用 2*1 的小矩形覆盖大矩形的第一列，其后 n-1 列则有 F(n - 1)种覆盖方法；
     *      2.先用两个 2*1 的小矩形覆盖大矩形的前两列，其后 n-2 列共有F(n - 2)种覆盖方法，
     *          故有递推公式 F(n) = F(n - 1) + F(n - 2)。
     *
     */
    public int RectCover(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        return RectCover(target - 1) + RectCover(target - 2);
    }
}