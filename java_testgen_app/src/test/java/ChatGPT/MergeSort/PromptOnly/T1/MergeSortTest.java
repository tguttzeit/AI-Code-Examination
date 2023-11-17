package ChatGPT.MergeSort.PromptOnly.T1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] arr = { 5, 2, 9, 1, 5 };
        int[] expected = { 1, 2, 5, 5, 9 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}
