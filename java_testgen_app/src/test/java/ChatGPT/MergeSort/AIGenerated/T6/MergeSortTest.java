package ChatGPT.MergeSort.AIGenerated.T6;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {};
        mergeSort.mergeSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortAlreadySortedArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 4, 2, 7, 1, 9, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 4, 5, 7, 9 };
        assertArrayEquals(expected, arr);
    }
}
