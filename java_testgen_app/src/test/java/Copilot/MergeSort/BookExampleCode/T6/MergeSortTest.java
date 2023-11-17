package Copilot.MergeSort.BookExampleCode.T6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort mergeSort;
    private int[] array;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
        array = new int[] { 3, 2, 1, 4, 5 };
    }

    @Test
    public void testMergeSort() {
        mergeSort.mergeSort(array);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testMergeSortWithOneElement() {
        mergeSort.mergeSort(new int[] { 1 });
        assertArrayEquals(new int[] { 1 }, array);
    }

    @Test
    public void testMergeSortWithNoElement() {
        mergeSort.mergeSort(new int[] {});
        assertArrayEquals(new int[] {}, array);
    }
}
