package Copilot.QuickSort.PromptOnly.T7;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        QuickSort qs = new QuickSort();
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        qs.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort2() {
        QuickSort qs = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        qs.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort3() {
        QuickSort qs = new QuickSort();
        int[] arr = {3, 2, 1, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        qs.sort(arr);
        assertArrayEquals(expected, arr);
    }

}