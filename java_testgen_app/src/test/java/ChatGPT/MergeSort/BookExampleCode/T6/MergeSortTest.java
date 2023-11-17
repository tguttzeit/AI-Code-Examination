package ChatGPT.MergeSort.BookExampleCode.T6;

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
    public void testMergeSortUnsortedArray() {
        int[] input = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
