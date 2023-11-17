package ChatGPT.MergeSort.PromptOnly.T7;

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
    public void testMergeSortSortedArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 5, 1, 4, 2, 3 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
