package ChatGPT.MergeSort.PromptOnly.T9;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortUnsortedArray() {
        int[] input = { 5, 1, 4, 2, 3 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);
    }
}
