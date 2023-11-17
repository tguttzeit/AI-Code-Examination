package Copilot.MergeSort.AIGenerated.T4;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSort() {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithNegativeValues() {
        int[] arr = { 5, -4, 3, 2, -1 };
        mergeSort.mergeSort(arr);
        int[] expected = { -4, -1, 2, 3, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithOddLengthArray() {
        int[] arr = { 5, 4, 3, 2, 1, 0 };
        mergeSort.mergeSort(arr);
        int[] expected = { 0, 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
