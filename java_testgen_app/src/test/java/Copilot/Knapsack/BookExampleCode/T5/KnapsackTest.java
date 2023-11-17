package Copilot.Knapsack.BookExampleCode.T5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    private Knapsack knapsack;

    @Before
    public void setUp() {
        knapsack = new Knapsack();
    }

    @Test
    public void testBottomUp_1() {
        int[] values = { 1, 2, 3 };
        int[] weights = { 4, 5, 1 };
        int weight = 4;
        assertEquals(3, knapsack.bottomUp(weight, weights, values));
    }

    @Test
    public void testBottomUp_2() {
        int[] values = { 1, 2, 3 };
        int[] weights = { 4, 5, 1 };
        int weight = 5;
        assertEquals(3, knapsack.bottomUp(weight, weights, values));
    }

    @Test
    public void testBottomUp_3() {
        int[] values = { 1, 2, 3 };
        int[] weights = { 4, 5, 1 };
        int weight = 6;
        assertEquals(4, knapsack.bottomUp(weight, weights, values));
    }
}