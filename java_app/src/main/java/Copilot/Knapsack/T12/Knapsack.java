package Copilot.Knapsack.T12;

public class Knapsack {


    // Implement the public int bottomUp(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
    public int bottomUp(int capacity, int[] weights, int[] values) {
        // Create a new int array with the length of the weights array + 1.
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // Iterate over the weights array.
        for (int i = 0; i <= weights.length; i++) {
            // Iterate over the capacity.
            for (int j = 0; j <= capacity; j++) {
                // Check if the current index is 0 or 0.
                if (i == 0 || j == 0) {
                    // Set the current index to 0.
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    // Set the current index to the max of the current index or the value of the current index and the value of the previous index.
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    // Set the current index to the value of the previous index.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the value of the last element in the dp array.
        return dp[weights.length][capacity];
    }





}
