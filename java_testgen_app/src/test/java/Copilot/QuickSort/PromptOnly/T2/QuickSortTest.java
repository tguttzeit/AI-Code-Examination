package Copilot.QuickSort.PromptOnly.T2;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        QuickSort qs = new QuickSort();
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        qs.sort(arr);
        assertEquals(arr, new int[] { 1, 5, 7, 8, 9, 10 });
    }
}