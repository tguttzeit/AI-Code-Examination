package Copilot.MergeSort.PromptOnly.T6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[] { 1, 3, 2, 4, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[] {};
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {}, array);
    }

    @Test
    public void testMergeSortWithOneElement() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[] { 1 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1 }, array);
    }
}
