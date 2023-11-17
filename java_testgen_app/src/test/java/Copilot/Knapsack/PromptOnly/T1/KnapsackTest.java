package Copilot.Knapsack.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testBottomUp() {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;
        assertEquals(220, new Knapsack().bottomUp(capacity, weights, values));
    }
}