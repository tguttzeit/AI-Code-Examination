package Copilot.MergeSort.BookExampleCode.T2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = { 3, 2, 1 };
        mergeSort.mergeSort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testMergeSortEmpty() {
        MergeSort mergeSort = new MergeSort();
        int[] array = {};
        mergeSort.mergeSort(array);
        assertEquals(0, array.length);
    }

    @Test
    public void testMergeSortOneElement() {
        MergeSort mergeSort = new MergeSort();
        int[] array = { 1 };
        mergeSort.mergeSort(array);
        assertEquals(1, array[0]);
    }
}
