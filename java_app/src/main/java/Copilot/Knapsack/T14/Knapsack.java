package Copilot.Knapsack.T14;

public class Knapsack {
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j - weights[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], values[i] + dp[i - 1][j - weights[i]]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        return dp[weights.length - 1][capacity];
    }

}
