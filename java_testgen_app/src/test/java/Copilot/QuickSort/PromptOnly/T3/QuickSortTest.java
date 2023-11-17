package Copilot.QuickSort.PromptOnly.T3;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        QuickSort q = new QuickSort();
        int[] a = { 5, 4, 3, 2, 1 };
        int[] b = { 1, 2, 3, 4, 5 };
        int[] c = { 1, 1, 1, 1, 1 };
        int[] d = { 2, 3, 1, 5, 4 };
        int[] e = { 1, 2, 3, 4, 5 };
        q.sort(a);
        q.sort(b);
        q.sort(c);
        q.sort(d);
        q.sort(e);
        assertArrayEquals(a, b);
        assertArrayEquals(c, d);
        assertArrayEquals(b, e);
    }
}