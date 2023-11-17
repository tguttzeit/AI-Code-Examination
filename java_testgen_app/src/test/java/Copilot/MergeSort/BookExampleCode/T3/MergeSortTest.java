package Copilot.MergeSort.BookExampleCode.T3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        int[] array = { 4, 2, 3, 1 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4 }, array);
    }

    @Test
    public void testMergeSort1() {
        int[] array = { 4, 2, 3, 1, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSort2() {
        int[] array = { 2 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 2 }, array);
    }
}
