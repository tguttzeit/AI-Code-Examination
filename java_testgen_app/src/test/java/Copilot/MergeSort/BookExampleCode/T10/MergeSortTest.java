package Copilot.MergeSort.BookExampleCode.T10;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = new int[] { 3, 5, 1, 2, 4 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] array = new int[] {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {}, array);
    }

    @Test
    public void testMergeSortOneElementArray() {
        int[] array = new int[] { 1 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1 }, array);
    }
}
