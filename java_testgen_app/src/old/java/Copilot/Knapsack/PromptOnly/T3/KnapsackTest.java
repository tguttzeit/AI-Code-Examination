package Copilot.Knapsack.PromptOnly.T3;


import org.junit.Test;
import static org.junit.Assert.*;
public class KnapsackTest {
    @Test
    public void testBottomUp() {
        assertEquals(220, Knapsack.bottomUp(50, new int[] {10, 20, 30}, new int[] {60, 100, 120}));
        assertEquals(0, Knapsack.bottomUp(0, new int[] {10, 20, 30}, new int[] {60, 100, 120}));
        assertEquals(0, Knapsack.bottomUp(50, new int[] {}, new int[] {}));
        assertEquals(0, Knapsack.bottomUp(0, new int[] {}, new int[] {}));
        assertEquals(0, Knapsack.bottomUp(0, new int[] {10, 20, 30}, new int[] {}));
        assertEquals(0, Knapsack.bottomUp(0, new int[] {}, new int[] {60, 100, 120}));
    }
}