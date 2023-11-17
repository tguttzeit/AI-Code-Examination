package Copilot.Knapsack.PromptOnly.T6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {
    @Test
    public void test1() {
        int[] weights = { 1, 2, 4, 2, 5 };
        int[] values = { 5, 3, 5, 3, 2 };
        int capacity = 10;
        int expected = 16;
        Knapsack k = new Knapsack();
        int actual = k.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] weights = { 1, 2, 4, 2, 5 };
        int[] values = { 5, 3, 5, 3, 2 };
        int capacity = 5;
        int expected = 8;
        Knapsack k = new Knapsack();
        int actual = k.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] weights = { 1, 2, 4, 2, 5 };
        int[] values = { 5, 3, 5, 3, 2 };
        int capacity = 20;
        int expected = 18;
        Knapsack k = new Knapsack();
        int actual = k.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
}