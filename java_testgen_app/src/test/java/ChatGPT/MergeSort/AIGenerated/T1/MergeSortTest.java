package ChatGPT.MergeSort.AIGenerated.T1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = {};
        sorter.mergeSort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        sorter.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortWithReverseSortedArray() {
        MergeSort sorter = new MergeSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        sorter.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
