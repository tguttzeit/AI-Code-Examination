package Copilot.Knapsack.AIGenerated.T10;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {
    @Test
    public void testEmpty() {
        int[] weights = {};
        int[] values = {};
        int capacity = 0;
        Knapsack knapsack = new Knapsack();
        assertEquals(0, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testOneItem() {
        int[] weights = {10};
        int[] values = {60};
        int capacity = 50;
        Knapsack knapsack = new Knapsack();
        assertEquals(0, knapsack.bottomUp(capacity, weights, values));
    }

    @Test
    public void testMultipleItems() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        Knapsack knapsack = new Knapsack();
        assertEquals(220, knapsack.bottomUp(capacity, weights, values));
    }
}