package Copilot.QuickSort.AIGenerated.T5;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuickSortTest {
    @Test
    public void testSort() {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    public void testSortWithDuplicates() {
        int[] arr = { 9, 8, 7, 6, 5, 5, 3, 2, 1 };

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    public void testSortWithNegatives() {
        int[] arr = { 9, 8, 7, 6, 5, -4, -3, -2, -1 };

        QuickSort sorter = new QuickSort();
        sorter.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
}