package Copilot.MergeSort.AIGenerated.T8;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void setUp() throws Exception {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSort() throws Exception {
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testMergeSort2() throws Exception {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testMergeSort3() throws Exception {
        int[] arr = { 1, 2, 3, 5, 4 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(arr, new int[] { 1, 2, 3, 4, 5 });
    }
}
