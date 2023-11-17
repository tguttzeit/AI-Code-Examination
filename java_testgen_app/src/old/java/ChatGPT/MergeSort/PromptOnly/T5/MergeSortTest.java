package ChatGPT.MergeSort.PromptOnly.T5;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] arr = { 5, 3, 1, 4, 2 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
