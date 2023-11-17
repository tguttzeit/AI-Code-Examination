package Copilot.QuickSort.AIGenerated.T8;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        int[] arr = { 1, 5, 2, 3, 6, 9, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 9 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithNegativeValues() {
        int[] arr = { -1, 5, 2, 3, 6, 9, 4 };
        int[] expected = { -1, 2, 3, 4, 5, 6, 9 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}