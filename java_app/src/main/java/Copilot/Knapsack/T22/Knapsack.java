package Copilot.Knapsack.T22;

public class Knapsack {

    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] table = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    table[i][j] = Math.max(values[i - 1] + table[i - 1][j - weights[i - 1]], table[i - 1][j]);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        return table[values.length][capacity];
    }


}
