package Copilot.QuickSort.AIGenerated.T3;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        int[] arr = {9, 7, 3, 1, 6, 3, 2, 6, 8, 4, 0};
        int[] expected = {0, 1, 2, 3, 3, 4, 6, 6, 7, 8, 9};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort2() {
        int[] arr = {9, 7, 3, 1, 6, 3, 2, 6, 8, 4, 0};
        int[] expected = {0, 1, 2, 3, 3, 4, 6, 6, 7, 8, 9};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSort3() {
        int[] arr = {9, 7, 3, 1, 6, 3, 2, 6, 8, 4, 0};
        int[] expected = {0, 1, 2, 3, 3, 4, 6, 6, 7, 8, 9};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

}