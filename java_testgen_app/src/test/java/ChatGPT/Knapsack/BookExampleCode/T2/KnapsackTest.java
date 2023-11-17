package ChatGPT.Knapsack.BookExampleCode.T2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {

    @Test
    public void testKnapsackCase1() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int weight = 5;
        int expected = 7; // The maximum value that can be obtained with a weight of 5
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase2() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int weight = 7;
        int expected = 9; // The maximum value that can be obtained with a weight of 7
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsackCase3() {
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3, 4, 5};
        int[] values = {2, 4, 4, 5, 10};
        int weight = 8;
        int expected = 13; // The maximum value that can be obtained with a weight of 8
        int result = knapsack.bottomUp(weight, weights, values);
        assertEquals(expected, result);
    }
}
