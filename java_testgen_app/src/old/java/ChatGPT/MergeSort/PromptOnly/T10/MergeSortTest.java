package ChatGPT.MergeSort.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortUnsortedArray() {
        int[] arr = { 5, 2, 9, 1, 5 };
        int[] expected = { 1, 2, 5, 5, 9 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
