package Copilot.Knapsack.BookExampleCode.T4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void test1() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        assertEquals(7, knapsack.bottomUp(5, weights, values));
    }

    @Test
    public void test2() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        assertEquals(9, knapsack.bottomUp(7, weights, values));
    }

    @Test
    public void test3() {
        Knapsack knapsack = new Knapsack();
        int[] weights = { 2, 3, 4, 5 };
        int[] values = { 3, 4, 5, 6 };
        assertEquals(9, knapsack.bottomUp(7, weights, values));
    }
}