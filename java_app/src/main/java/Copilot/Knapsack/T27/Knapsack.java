package Copilot.Knapsack.T27;

public class Knapsack {

    public int bottomUp(int capacity, int[] weights, int[] values) {

        // Create a 2D array to store the maximum value at each capacity for each item.
        int[][] maxValues = new int[weights.length + 1][capacity + 1];

        // Fill the array with the maximum values.
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    maxValues[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    maxValues[i][j] = Math.max(values[i - 1] + maxValues[i - 1][j - weights[i - 1]], maxValues[i - 1][j]);
                } else {
                    maxValues[i][j] = maxValues[i - 1][j];
                }
            }
        }

        // Return the maximum value.
        return maxValues[weights.length][capacity];
    }

}
