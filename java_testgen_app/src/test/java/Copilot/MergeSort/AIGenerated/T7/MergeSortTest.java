package Copilot.MergeSort.AIGenerated.T7;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr1 = { 2, 1, 4, 3 };
        int[] arr2 = { 1, 2, 3, 4 };
        int[] arr3 = { 4, 3, 2, 1 };
        int[] arr4 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        MergeSort mergeSort = new MergeSort();

        mergeSort.mergeSort(arr1);
        mergeSort.mergeSort(arr2);
        mergeSort.mergeSort(arr3);
        mergeSort.mergeSort(arr4);

        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr1);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr2);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr3);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, arr4);
    }
}
