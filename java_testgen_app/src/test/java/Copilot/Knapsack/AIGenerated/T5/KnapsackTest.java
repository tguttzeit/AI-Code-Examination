package Copilot.Knapsack.AIGenerated.T5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 3, 2, 1 };
        int[] values = { 5, 3, 4 };
        int capacity = 5;
        assertEquals(9, knapsack.bottomUp(capacity, weights, values));
    }
}