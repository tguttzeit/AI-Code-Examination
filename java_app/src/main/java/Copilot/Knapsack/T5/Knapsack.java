package Copilot.Knapsack.T5;

public class Knapsack {


    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] dp = new int[weights.length+1][capacity+1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i-1] <= j) {
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weights.length][capacity];
    }



}
