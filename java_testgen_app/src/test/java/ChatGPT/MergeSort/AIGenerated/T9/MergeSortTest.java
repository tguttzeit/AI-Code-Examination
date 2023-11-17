package ChatGPT.MergeSort.AIGenerated.T9;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {};
        mergeSort.mergeSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithReverseSortedArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = { 3, 1, 4, 2, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
