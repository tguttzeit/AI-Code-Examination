package Copilot.Knapsack.BookExampleCode.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack knapsack = new Knapsack();
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int weight = 50;
        int expected = 220;
        int actual = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, actual);
    }
}