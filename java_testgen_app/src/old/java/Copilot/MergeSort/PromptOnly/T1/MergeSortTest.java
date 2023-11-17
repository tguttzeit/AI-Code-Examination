package Copilot.MergeSort.PromptOnly.T1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = { 3, 5, 1, 4, 2 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] array = {};
        int[] expected = {};
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortWithOneElement() {
        int[] array = { 1 };
        int[] expected = { 1 };
        MergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }
}
