package ChatGPT.MergeSort.AIGenerated.T2;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = {};
        sorter.mergeSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSortedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        sorter.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        sorter.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        sorter.mergeSort(arr);
        int[] expected = { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 };
        assertArrayEquals(expected, arr);
    }
}
