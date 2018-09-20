package swordOffer.no007;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fibonacci(39));
    }

    public static int fibonacci(int n) {

        int res = 0;
        int[] fib = new int[39];
        for (int i = 0; i < fib.length; i++) {
            if (i == 0) {
                fib[i] = 0;
            } else if (i == 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 2] + fib[i - 1];
            }
        }

        for (int i = 0; i < fib.length; i++) {
            if (i == n) {
                res = fib[i];
                break;
            }
        }

        return res;
    }
}
