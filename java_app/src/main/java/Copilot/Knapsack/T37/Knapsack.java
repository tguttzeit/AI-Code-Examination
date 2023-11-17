package Copilot.Knapsack.T37;

public class Knapsack {

    // The bottomUp method should return the maximum value of the items that can be placed in the knapsack.
    public int bottomUp(int capacity, int[] weights, int[] values) {
        int[] maxValues = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                maxValues[j] = Math.max(maxValues[j], maxValues[j - weights[i]] + values[i]);
            }
        }
        return maxValues[capacity];
    }

}
