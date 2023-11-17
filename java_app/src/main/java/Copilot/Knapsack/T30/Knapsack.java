package Copilot.Knapsack.T30;

public class Knapsack {


    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] table = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        return table[values.length][capacity];
    }

    // Implement the public int topDown(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
    public int topDown(int capacity, int[] weights, int[] values) {
        int[][] table = new int[values.length + 1][capacity + 1];
        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                table[i][j] = -1;
            }
        }
        return topDownHelper(capacity, weights, values, table, values.length);
    }

    public int topDownHelper(int capacity, int[] weights, int[] values, int[][] table, int i) {
        if (i == 0 || capacity == 0) {
            return 0;
        }
        if (table[i][capacity] != -1) {
            return table[i][capacity];
        }
        if (weights[i - 1] > capacity) {
            table[i][capacity] = topDownHelper(capacity, weights, values, table, i - 1);
        } else {
            table[i][capacity] = Math.max(values[i - 1] + topDownHelper(capacity - weights[i - 1], weights, values, table, i - 1),
                    topDownHelper(capacity, weights, values, table, i - 1));
        }
        return table[i][capacity];
    }

// Implement the public int recursive(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.



}
