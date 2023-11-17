package Copilot.MergeSort.BookExampleCode.T7;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = { 3, 1, 2, 4, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortEmpty() {
        MergeSort mergeSort = new MergeSort();
        int[] array = {};
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] {}, array);
    }

    @Test
    public void testMergeSortNegative() {
        MergeSort mergeSort = new MergeSort();
        int[] array = { -3, 1, -2, 4, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { -3, -2, 1, 4, 5 }, array);
    }
}
