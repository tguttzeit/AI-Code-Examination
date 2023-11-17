package ChatGPT.MergeSort.PromptOnly.T6;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] input = {};
        MergeSort.mergeSort(input);
        int[] expected = {};
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(input);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] input = { 5, 3, 1, 4, 2 };
        MergeSort.mergeSort(input);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, input);
    }
}
