package Copilot.Knapsack.T20;

public class Knapsack {
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int value = values[i - 1];
                    int weight = weights[i - 1];

                    if (j - weight >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[values.length][capacity];
    }

}
