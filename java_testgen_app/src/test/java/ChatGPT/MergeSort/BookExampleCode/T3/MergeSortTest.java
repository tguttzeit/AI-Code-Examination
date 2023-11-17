package ChatGPT.MergeSort.BookExampleCode.T3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] arr = { 5, 3, 2, 4, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
