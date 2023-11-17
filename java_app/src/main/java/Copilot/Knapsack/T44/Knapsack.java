package Copilot.Knapsack.T44;

public class Knapsack {

    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int itemWeight = weights[i - 1];
                int itemValue = values[i - 1];

                if (j < itemWeight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int remainingCapacity = j - itemWeight;
                    int valueWithItem = itemValue + dp[i - 1][remainingCapacity];
                    int valueWithoutItem = dp[i - 1][j];
                    dp[i][j] = Math.max(valueWithItem, valueWithoutItem);
                }
            }
        }

        return dp[weights.length][capacity];
    }


}
