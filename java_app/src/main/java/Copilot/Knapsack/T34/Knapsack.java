package Copilot.Knapsack.T34;

public class Knapsack {

    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] K = new int[values.length + 1][capacity + 1];

        for (int i = 0; i <= values.length; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weights[i - 1] <= w)
                    K[i][w] = Math.max(values[i - 1]
                            + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[values.length][capacity];
    }


}
