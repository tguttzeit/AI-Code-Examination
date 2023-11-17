package ChatGPT.MergeSort.AIGenerated.T10;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

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
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortReverseSortedArray() {
        int[] arr = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMergeSortRandomArray() {
        int[] arr = { 3, 1, 4, 2, 5 };
        mergeSort.mergeSort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
