package ChatGPT.Knapsack.AIGenerated.T8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsack1() {
        Knapsack knapsack = new Knapsack();
        int capacity = 5;
        int[] weights = {2, 1, 3, 2};
        int[] values = {12, 10, 20, 15};
        int expected = 37; // The optimal solution is to take items 1 and 3.
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack2() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {5, 4, 6, 3};
        int[] values = {10, 40, 30, 50};
        int expected = 90; // The optimal solution is to take all items.
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack3() {
        Knapsack knapsack = new Knapsack();
        int capacity = 7;
        int[] weights = {4, 2, 3};
        int[] values = {10, 7, 8};
        int expected = 13; // The optimal solution is to take items 2 and 3.
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(expected, result);
    }
}
