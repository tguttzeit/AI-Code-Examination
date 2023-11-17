package Copilot.MergeSort.BookExampleCode.T4;

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
        int[] array = new int[] { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSort2() {
        int[] array = new int[] { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSort3() {
        int[] array = new int[] { 2, 4, 3, 1, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }
}
