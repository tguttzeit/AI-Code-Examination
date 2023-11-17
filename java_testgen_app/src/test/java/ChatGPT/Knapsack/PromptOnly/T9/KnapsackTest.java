package ChatGPT.Knapsack.PromptOnly.T9;

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
    public void testKnapsackWithExample1() {
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result); // Maximum value should be 7
    }

    @Test
    public void testKnapsackWithExample2() {
        int capacity = 8;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(9, result); // Maximum value should be 9
    }

    @Test
    public void testKnapsackWithExample3() {
        int capacity = 6;
        int[] weights = {2, 2, 2, 3};
        int[] values = {4, 5, 6, 7};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(10, result); // Maximum value should be 10
    }
}
