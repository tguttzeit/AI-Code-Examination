package ChatGPT.MergeSort.PromptOnly.T6;

import ChatGPT.MergeSort.PromptOnly.T3.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] input = {};
        new MergeSort().mergeSort(input);
        int[] expected = {};
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        new MergeSort().mergeSort(input);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] input = { 5, 3, 1, 4, 2 };
        new MergeSort().mergeSort(input);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, input);
    }
}
