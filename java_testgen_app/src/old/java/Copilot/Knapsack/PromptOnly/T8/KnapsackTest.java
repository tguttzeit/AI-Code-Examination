package Copilot.Knapsack.PromptOnly.T8;

import static org.junit.Assert.*;


import org.junit.Test;

public class KnapsackTest {
    @Test
    public void test1() {
        int capacity = 10;
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int expected = 9;
        int actual = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int capacity = 10;
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int expected = 9;
        int actual = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        int capacity = 10;
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int expected = 9;
        int actual = Knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, actual);
    }

}