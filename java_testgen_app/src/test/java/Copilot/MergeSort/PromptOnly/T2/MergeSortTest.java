package Copilot.MergeSort.PromptOnly.T2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] input = { 1, 5, 3, 4, 2, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
