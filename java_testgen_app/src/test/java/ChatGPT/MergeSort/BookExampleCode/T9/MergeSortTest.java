package ChatGPT.MergeSort.BookExampleCode.T9;

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
    public void testMergeSortAlreadySortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        int[] input = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] input = { 3, 1, 4, 2, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
