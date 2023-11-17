package Copilot.MergeSort.BookExampleCode.T9;

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
    public void mergeSortTest1() {
        int[] array = { 1, 5, 4, 3, 2, 7, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7 };
        mergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void mergeSortTest2() {
        int[] array = { 3, 2, 1 };
        int[] expected = { 1, 2, 3 };
        mergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void mergeSortTest3() {
        int[] array = { 1, 2, 3 };
        int[] expected = { 1, 2, 3 };
        mergeSort.mergeSort(array);
        assertArrayEquals(expected, array);
    }
}
