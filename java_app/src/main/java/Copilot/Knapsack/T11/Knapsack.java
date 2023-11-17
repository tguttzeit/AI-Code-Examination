package Copilot.Knapsack.T11;

public class Knapsack {
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] memo = new int[weights.length + 1][capacity + 1];
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    memo[i][j] = Math.max(memo[i - 1][j], values[i - 1] + memo[i - 1][j - weights[i - 1]]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[weights.length][capacity];
    }
}
