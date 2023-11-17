package Copilot.MergeSort.BookExampleCode.T1;

import static org.junit.Assert.assertEquals;

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
        int[] array = { 3, 2, 1 };
        mergeSort.mergeSort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testMergeSort2() {
        int[] array = { 1, 2, 3 };
        mergeSort.mergeSort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testMergeSort3() {
        int[] array = { 2, 1, 3 };
        mergeSort.mergeSort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }
}
