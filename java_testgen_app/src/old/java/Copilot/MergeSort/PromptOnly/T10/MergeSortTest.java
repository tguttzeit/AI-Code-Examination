package Copilot.MergeSort.PromptOnly.T10;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        // Test case 1
        int[] input = { 1, 5, 3, 2, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);

        // Test case 2
        int[] input = { 1, 5, 3, 2, 4, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);

        // Test case 3
        int[] input = { 1, 5, 3, 2, 4, 6, 9, 8, 7 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
