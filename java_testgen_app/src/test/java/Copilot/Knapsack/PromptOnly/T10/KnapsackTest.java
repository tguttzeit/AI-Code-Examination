package Copilot.Knapsack.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {
    @Test
    public void testBottomUp() {
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int capacity = 50;
        assertEquals(220, new Knapsack().bottomUp(capacity, weights, values));
    }

    @Test
    public void testBottomUp2() {
        int[] weights = { 10, 20, 30, 40, 50 };
        int[] values = { 60, 100, 120, 200, 300 };
        int capacity = 100;
        assertEquals(600, new Knapsack().bottomUp(capacity, weights, values));
    }

    @Test
    public void testBottomUp3() {
        int[] weights = { 10, 20, 30, 40, 50 };
        int[] values = { 60, 100, 120, 200, 300 };
        int capacity = 500;
        assertEquals(780, new Knapsack().bottomUp(capacity, weights, values));
    }
}