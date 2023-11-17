package Copilot.Knapsack.T43;

public class Knapsack {
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                int prev = dp[i - 1][j];
                if (j >= weights[i - 1]) {
                    prev = Math.max(prev, dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }

                dp[i][j] = prev;
            }
        }

        return dp[weights.length][capacity];
    }


}
