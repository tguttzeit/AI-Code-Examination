package Copilot.MergeSort.BookExampleCode.T5;

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
        int[] array = { 5, 4, 3, 2, 1 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortWithNegativeNumbers() {
        int[] array = { 5, 4, 3, 2, 1, -1, -2, -3, -4, -5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { -5, -4, -3, -2, -1, 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortWithDuplicates() {
        int[] array = { 5, 4, 3, 2, 1, -1, -2, -3, -4, -5, 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { -5, -4, -3, -2, -1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, array);
    }
}
