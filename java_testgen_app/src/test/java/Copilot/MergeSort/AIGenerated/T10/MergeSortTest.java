package Copilot.MergeSort.AIGenerated.T10;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr1 = { 2, 1, 4, 3 };
        int[] arr2 = { 1, 2, 3, 4 };
        int[] arr3 = { 4, 3, 2, 1 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr1);
        mergeSort.mergeSort(arr2);
        mergeSort.mergeSort(arr3);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr1);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr2);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, arr3);
    }
}
