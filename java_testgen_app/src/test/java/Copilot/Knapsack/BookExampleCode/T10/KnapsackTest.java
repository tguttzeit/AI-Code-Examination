package Copilot.Knapsack.BookExampleCode.T10;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class KnapsackTest {
    @Test
    public void testKnapsack() {
        Knapsack k = new Knapsack();
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int weight = 50;
        assertEquals(220, k.bottomUp(weight, weights, values));
    }
    @Test
    public void testKnapsack2() {
        Knapsack k = new Knapsack();
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int weight = 40;
        assertEquals(160, k.bottomUp(weight, weights, values));
    }
    @Test
    public void testKnapsack3() {
        Knapsack k = new Knapsack();
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int weight = 30;
        assertEquals(120, k.bottomUp(weight, weights, values));
    }
}