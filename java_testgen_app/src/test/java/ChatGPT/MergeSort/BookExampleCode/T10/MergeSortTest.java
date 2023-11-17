package ChatGPT.MergeSort.BookExampleCode.T10;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] input = {};
        int[] expected = {};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] input = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }
}
