package ChatGPT.MergeSort.AIGenerated.T5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        mergeSort.mergeSort(arr);
        int[] expected = {};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortAlreadySortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] arr = { 7, 2, 9, 1, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 5, 7, 9 };
        Assert.assertArrayEquals(expected, arr);
    }
}
