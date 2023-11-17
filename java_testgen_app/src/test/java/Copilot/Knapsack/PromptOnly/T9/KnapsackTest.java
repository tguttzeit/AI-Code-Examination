package Copilot.Knapsack.PromptOnly.T9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class KnapsackTest {
    @Test
    public void testBottomUp() {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;
        int expected = 9;
        Knapsack knapsack = new Knapsack();
        int actual = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
    @Test
    public void testBottomUp2() {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 0;
        int expected = 0;
        Knapsack knapsack = new Knapsack();
        int actual = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
    @Test
    public void testBottomUp3() {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 10;
        int expected = 12;
        Knapsack knapsack = new Knapsack();
        int actual = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
}