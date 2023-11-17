package Copilot.Knapsack.T35;

public class Knapsack {



    public int bottomUp(int capacity, int[] weights, int[] values) {

        // Create a 2D array with dimensions weights.length + 1 and capacity + 1.
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // Iterate through the rows and columns of the array.
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {

                // If the row or column is 0, set the value to 0.
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                // If the weight of the previous row is less than or equal to the current column, set the value to the maximum of the previous value and the value of the current row plus the value of the previous row at the current column minus the weight of the previous row.
                else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                }

                // Otherwise, set the value to the value of the previous row at the current column.
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the value of the last row and last column.
        return dp[weights.length][capacity];
    }

}
