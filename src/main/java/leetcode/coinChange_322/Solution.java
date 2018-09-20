package leetcode.coinChange_322;

public class Solution {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        if (null == coins || amount == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }
}
