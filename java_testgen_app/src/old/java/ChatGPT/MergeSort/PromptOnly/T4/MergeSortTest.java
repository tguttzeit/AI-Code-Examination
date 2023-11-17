package ChatGPT.MergeSort.PromptOnly.T4;

import static org.junit.Assert.*;
import org.junit.Test;

public class MergeSortTest {

    // Test case 1: Testing with a simple array
    @Test
    public void testMergeSortSimpleArray() {
        int[] arr = { 5, 2, 9, 1, 5 };
        int[] expected = { 1, 2, 5, 5, 9 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    // Test case 2: Testing with an already sorted array
    @Test
    public void testMergeSortSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    // Test case 3: Testing with an empty array
    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
