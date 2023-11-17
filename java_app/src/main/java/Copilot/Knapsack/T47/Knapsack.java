package Copilot.Knapsack.T47;

public class Knapsack {



    // Bottom Up 0-1 Knapsack
    public int bottomUp(int capacity, int[] weights, int[] values) {

        // Create a 2D array with the size of the weights array and capacity + 1
        int[][] knapsack = new int[weights.length][capacity + 1];

        // Loop through the rows of the knapsack array
        for (int i = 0; i < weights.length; i++) {

            // Loop through the columns of the knapsack array
            for (int j = 0; j <= capacity; j++) {

                // Check if the weight of the current item is greater than the current capacity
                if (weights[i] > j) {

                    // If it is, then set the value of the current cell to the value of the cell above it
                    knapsack[i][j] = knapsack[i - 1][j];

                } else {

                    // If it isn't, then set the value of the current cell to the maximum value between the value of the cell above it and the value of the cell above it, minus the weight of the current item, plus the value of the current item
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - weights[i]] + values[i]);

                }

            }

        }

        // Return the value of the last cell in the knapsack array
        return knapsack[weights.length - 1][capacity];

    }




}
