package ChatGPT.QuickSort.BookExampleCode.T10;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortEmptyArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {};
        sorter.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortSortedArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortRandomArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {5, 1, 3, 4, 2};
        sorter.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }
}
