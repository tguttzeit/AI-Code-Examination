package Copilot.QuickSort.AIGenerated.T9;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort2() {
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort3() {
        int[] arr = { 1, 5, 2, 4, 3 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}