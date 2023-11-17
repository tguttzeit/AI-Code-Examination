package Copilot.MergeSort.AIGenerated.T3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    private int[] arr1 = { 5, 2, 4, 6, 1, 3 };
    private int[] arr2 = { 1, 2, 3, 4, 5, 6 };
    private int[] arr3 = { 6, 5, 4, 3, 2, 1 };

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr1);
        mergeSort.mergeSort(arr2);
        mergeSort.mergeSort(arr3);

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr1);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr2);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr3);
    }
}
