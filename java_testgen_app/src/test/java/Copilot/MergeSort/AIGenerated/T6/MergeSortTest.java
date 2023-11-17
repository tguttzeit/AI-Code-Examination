package Copilot.MergeSort.AIGenerated.T6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort2() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSort3() {
        int[] arr = { 6, 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
