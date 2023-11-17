package Copilot.QuickSort.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.*;
public class QuickSortTest {
    @Test
    public void testSort() {
        QuickSort qs = new QuickSort();
        int[] test1 = { 1, 2, 3, 4, 5 };
        int[] test2 = { 5, 4, 3, 2, 1 };
        int[] test3 = { 2, 1, 3, 5, 4 };
        qs.sort(test1);
        qs.sort(test2);
        qs.sort(test3);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, test1);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, test2);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, test3);
    }
}