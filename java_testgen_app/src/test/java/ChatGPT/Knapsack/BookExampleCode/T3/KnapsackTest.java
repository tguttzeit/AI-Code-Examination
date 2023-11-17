package ChatGPT.Knapsack.BookExampleCode.T3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackCase1() {
        Knapsack knapsack = new Knapsack();
        int weight = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int expected = 7; // The maximum value with a weight limit of 10.
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase2() {
        Knapsack knapsack = new Knapsack();
        int weight = 7;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int expected = 9; // The maximum value with a weight limit of 7.
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase3() {
        Knapsack knapsack = new Knapsack();
        int weight = 6;
        int[] weights = {2, 2, 2};
        int[] values = {3, 4, 5};
        int expected = 9; // The maximum value with a weight limit of 6.
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
