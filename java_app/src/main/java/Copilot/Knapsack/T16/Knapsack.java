package Copilot.Knapsack.T16;

public class Knapsack {

    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] table = new int[weights.length + 1][capacity + 1];

        // Fill the table with values
        for (int i = 0; i < weights.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        // Return the value in the bottom right corner
        return table[weights.length][capacity];
    }


}
