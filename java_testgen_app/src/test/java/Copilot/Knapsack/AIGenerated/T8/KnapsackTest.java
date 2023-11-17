package Copilot.Knapsack.AIGenerated.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        assertEquals(220, knapsack.bottomUp(50, new int[]{10, 20, 30}, new int[]{60, 100, 120}));
        assertEquals(0, knapsack.bottomUp(0, new int[]{10, 20, 30}, new int[]{60, 100, 120}));
        assertEquals(0, knapsack.bottomUp(50, new int[]{}, new int[]{}));
        assertEquals(9, knapsack.bottomUp(3, new int[]{1, 2, 3}, new int[]{3, 4, 5}));
    }
}