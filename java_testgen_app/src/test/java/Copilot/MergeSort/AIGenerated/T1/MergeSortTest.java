package Copilot.MergeSort.AIGenerated.T1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void TestMergeSort() {
        MergeSort ms = new MergeSort();
        int[] arr1 = { 5, 4, 3, 2, 1 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] arr3 = { 5, 5, 5, 5, 5 };
        ms.mergeSort(arr1);
        ms.mergeSort(arr2);
        ms.mergeSort(arr3);
        assertArrayEquals(arr1, arr2);
        assertArrayEquals(arr2, arr3);
    }
}
