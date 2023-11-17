package Copilot.Knapsack.T1;

// Implement a non-static 0-1 knapsack class named Knapsack.
// Implement the public int bottomUp(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
public class Knapsack {

    // The capacity of the knapsack
    private int capacity;

    // The weights of the items
    private int[] weights;

    // The values of the items
    private int[] values;

    // The maximum value
    private int max;

    // Constructor
    public Knapsack(int capacity, int[] weights, int[] values) {
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
    }

    // Implement the public int bottomUp(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];

            for (int j = 1; j <= capacity; j++) {
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        return dp[n][capacity];
    }

    // Implement the public int topDown(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
    public int topDown(int capacity, int[] weights, int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];

            for (int j = 1; j <= capacity; j++) {
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }

        return dp[n][capacity];

    }
}
