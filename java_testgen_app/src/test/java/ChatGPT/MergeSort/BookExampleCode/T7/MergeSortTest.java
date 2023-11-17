package ChatGPT.MergeSort.BookExampleCode.T7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] input = {};
        int[] expected = {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithReverseSortedArray() {
        int[] input = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] input = { 4, 2, 9, 5, 1, 6 };
        int[] expected = { 1, 2, 4, 5, 6, 9 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
