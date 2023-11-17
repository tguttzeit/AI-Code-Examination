package Copilot.MergeSort.AIGenerated.T5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] arr = { 5, 1, 6, 2, 3, 4 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr);
    }
}
