package Copilot.Knapsack.T29;

public class Knapsack {
    public static int bottomUp(int capacity, int[] weights, int[] values) {
        if (weights.length != values.length) {
            throw new IllegalArgumentException("The length of weights and values must be the same");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        int[][] dp = new int[weights.length + 1][capacity + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[weights.length][capacity];
    }
}
