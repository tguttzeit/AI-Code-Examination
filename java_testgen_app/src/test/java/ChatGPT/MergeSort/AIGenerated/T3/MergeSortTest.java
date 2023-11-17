package ChatGPT.MergeSort.AIGenerated.T3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();

        // Test Case 1: Sorting an already sorted array should produce the same result.
        int[] arr1 = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr1);
        int[] expected1 = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected1, arr1);

        // Test Case 2: Sorting a reverse-sorted array should produce a sorted array.
        int[] arr2 = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr2);
        int[] expected2 = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected2, arr2);

        // Test Case 3: Sorting an array with duplicate elements.
        int[] arr3 = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        mergeSort.mergeSort(arr3);
        int[] expected3 = { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 };
        assertArrayEquals(expected3, arr3);
    }
}
