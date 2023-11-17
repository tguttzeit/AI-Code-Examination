package Copilot.Knapsack.BookExampleCode.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    Knapsack knapsack = new Knapsack();

    @Test
    public void testBottomUp() {
        int[] weights = { 1, 2, 3 };
        int[] values = { 6, 10, 12 };
        assertEquals(22, knapsack.bottomUp(5, weights, values));
    }

    @Test
    public void testBottomUp2() {
        int[] weights = { 1, 2, 3, 4, 5 };
        int[] values = { 6, 10, 12, 13, 14 };
        assertEquals(22, knapsack.bottomUp(5, weights, values));
    }

    @Test
    public void testBottomUp3() {
        int[] weights = { 1, 2, 3, 4, 5 };
        int[] values = { 6, 10, 12, 13, 14 };
        assertEquals(0, knapsack.bottomUp(0, weights, values));
    }
}