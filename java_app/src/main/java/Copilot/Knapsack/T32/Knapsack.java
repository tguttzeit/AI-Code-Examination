package Copilot.Knapsack.T32;

public class Knapsack {



    // Implement a non-static 0-1 knapsack class named Knapsack.
    // Implement the public int bottomUp(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
    public int bottomUp(int capacity, int[] weights, int[] values) {
        // Create a new int[][] array named dp with the size of weights.length + 1 and capacity + 1.
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // Iterate through the dp array from i = 1 to i <= weights.length.
        for (int i = 1; i <= weights.length; i++) {
            // Iterate through the dp[i] array from j = 1 to j <= capacity.
            for (int j = 1; j <= capacity; j++) {
                // If weights[i - 1] is less than or equal to j.
                if (weights[i - 1] <= j) {
                    // Set dp[i][j] to the maximum of dp[i - 1][j] and dp[i - 1][j - weights[i - 1]] + values[i - 1].
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
                // Else
                else {
                    // Set dp[i][j] to dp[i - 1][j].
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return dp[weights.length][capacity].
        return dp[weights.length][capacity];
    }

}
