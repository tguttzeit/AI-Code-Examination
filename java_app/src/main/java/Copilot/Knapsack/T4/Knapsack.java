package Copilot.Knapsack.T4;

public class Knapsack {

    // The method should return an int with the maximum value.
    public int bottomUp(int capacity, int[] weights, int[] values) {
        // Create a 2D array to store the maximum value at each capacity from 0 to capacity.
        int[][] table = new int[weights.length + 1][capacity + 1];
        // Fill the table with 0's.
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                table[i][j] = 0;
            }
        }
        // Iterate through the rows of the table.
        for (int i = 1; i <= weights.length; i++) {
            // Iterate through the columns of the table.
            for (int j = 0; j <= capacity; j++) {
                // If the weight at the current index is less than or equal to the current capacity.
                if (weights[i - 1] <= j) {
                    // Set the current value in the table to the maximum of the current value and the sum of the value at the current index and the value at the current capacity minus the weight at the current index.
                    table[i][j] = Math.max(table[i - 1][j], values[i - 1] + table[i - 1][j - weights[i - 1]]);
                }
                // Otherwise, set the current value in the table to the value at the previous index.
                else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        // Return the value at the last index of the table.
        return table[weights.length][capacity];
    }


}
