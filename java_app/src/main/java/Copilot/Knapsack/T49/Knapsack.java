package Copilot.Knapsack.T49;

public class Knapsack {


    public int bottomUp(int capacity, int[] weights, int[] values) {

        // Create a 2D array to store the results of subproblems
        int[][] K = new int[weights.length + 1][capacity + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (weights[i - 1] <= j)
                    K[i][j] = Math.max(values[i - 1] + K[i - 1][j - weights[i - 1]], K[i - 1][j]);
                else
                    K[i][j] = K[i - 1][j];
            }
        }

        // Return the value in the last cell
        return K[weights.length][capacity];
    }

}