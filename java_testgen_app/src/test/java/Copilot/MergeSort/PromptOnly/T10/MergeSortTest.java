package Copilot.MergeSort.PromptOnly.T10;

import ChatGPT.MergeSort.PromptOnly.T3.MergeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {


    @Test
    public void testMergeSort() {
        // Test case 1
        int[] input = { 1, 5, 3, 2, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        new MergeSort().mergeSort(input);
        assertArrayEquals(expected, input);

        // Test case 2
        int[] input1 = { 1, 5, 3, 2, 4, 6 };
        int[] expected1 = { 1, 2, 3, 4, 5, 6 };
        new MergeSort().mergeSort(input);
        assertArrayEquals(expected, input);

        // Test case 3
        int[] input2 = { 1, 5, 3, 2, 4, 6, 9, 8, 7 };
        int[] expected2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        new MergeSort().mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
