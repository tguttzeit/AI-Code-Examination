package ChatGPT.MergeSort.BookExampleCode.T2;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortReverseArray() {
        int[] input = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] input = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        int[] expected = { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
