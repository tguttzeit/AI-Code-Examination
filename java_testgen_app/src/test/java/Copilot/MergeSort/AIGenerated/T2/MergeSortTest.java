package Copilot.MergeSort.AIGenerated.T2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    public void testMergeSort2() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    public void testMergeSort3() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 5, 1, 3, 2, 4 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }
}
