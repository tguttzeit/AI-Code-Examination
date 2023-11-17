package Copilot.MergeSort.PromptOnly.T4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MergeSortTest {
    MergeSort mergeSort;

    @Test
    public void testMergeSort() {
        int[] arr1 = { 5, 4, 3, 2, 1 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] arr3 = { 1, 1, 1, 1, 1 };
        int[] arr4 = { 1 };
        int[] arr5 = {};
        int[] arr6 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        mergeSort.mergeSort(arr1);
        mergeSort.mergeSort(arr2);
        mergeSort.mergeSort(arr3);
        mergeSort.mergeSort(arr4);
        mergeSort.mergeSort(arr5);
        mergeSort.mergeSort(arr6);

        assertEquals(arr1, new int[] { 1, 2, 3, 4, 5 });
        assertEquals(arr2, new int[] { 1, 2, 3, 4, 5 });
        assertEquals(arr3, new int[] { 1, 1, 1, 1, 1 });
        assertEquals(arr4, new int[] { 1 });
        assertEquals(arr5, new int[] {});
        assertEquals(arr6, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    }
}
