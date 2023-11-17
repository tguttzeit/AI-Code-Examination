package ChatGPT.MergeSort.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] input = { 5, 1, 4, 2, 8, 7 };
        int[] expected = { 1, 2, 4, 5, 7, 8 };
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
