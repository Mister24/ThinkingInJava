package swordOffer.no008;


/**
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * */
public class Solution {

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }

    public static int JumpFloor(int target) {

        int res = 0;
        if (target < 0) {
            return 0;
        }

        int[] fib = new int[target + 1];
        for (int i = 0; i < fib.length; i++) {
            if ( i == 0 || i == 1 || i == 2) {
                fib[i] = i;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        for (int i = 0; i < fib.length; i++) {
            if (i == target) {
                res = fib[i];
            }
        }

        return res;
    }
}
