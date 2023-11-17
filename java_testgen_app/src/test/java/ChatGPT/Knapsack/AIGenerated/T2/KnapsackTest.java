package ChatGPT.Knapsack.AIGenerated.T2;

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
    public void testKnapsackCase1() {
        int capacity = 10;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(7, result);
    }

    @Test
    public void testKnapsackCase2() {
        int capacity = 7;
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(9, result);
    }

    @Test
    public void testKnapsackCase3() {
        int capacity = 5;
        int[] weights = {3, 2, 1};
        int[] values = {6, 4, 2};
        int result = knapsack.bottomUp(capacity, weights, values);
        assertEquals(6, result);
    }
}
