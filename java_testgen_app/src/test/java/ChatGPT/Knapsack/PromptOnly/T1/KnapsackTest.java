package ChatGPT.Knapsack.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testKnapsackWithExample1() {
        Knapsack knapsack = new Knapsack();
        int capacity = 5;
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result);
    }

    @Test
    public void testKnapsackWithExample2() {
        Knapsack knapsack = new Knapsack();
        int capacity = 10;
        int[] weights = {2, 5, 7, 3};
        int[] values = {10, 20, 30, 5};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(35, result);
    }

    @Test
    public void testKnapsackWithExample3() {
        Knapsack knapsack = new Knapsack();
        int capacity = 8;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(9, result);
    }
}
