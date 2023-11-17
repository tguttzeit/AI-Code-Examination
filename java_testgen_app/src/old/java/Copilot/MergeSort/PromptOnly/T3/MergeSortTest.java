package Copilot.MergeSort.PromptOnly.T3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 4, 3, 2, 1 };
        int[] arr3 = { 3, 1, 5, 2, 4 };

        MergeSort.mergeSort(arr1);
        MergeSort.mergeSort(arr2);
        MergeSort.mergeSort(arr3);

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr1);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr2);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr3);
    }
}
