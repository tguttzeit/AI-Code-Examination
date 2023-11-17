package ChatGPT.MergeSort.AIGenerated.T7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = {};
        int[] expected = {};
        sorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortAlreadySortedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        sorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        sorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReversedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        sorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
