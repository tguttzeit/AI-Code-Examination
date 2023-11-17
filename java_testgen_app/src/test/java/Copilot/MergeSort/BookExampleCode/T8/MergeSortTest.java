package Copilot.MergeSort.BookExampleCode.T8;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] actual = {};
        int[] expected = {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMergeSortWithOneElement() {
        int[] actual = { 1 };
        int[] expected = { 1 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(actual);
        assertArrayEquals(expected, actual);
    }
}
