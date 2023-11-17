package ChatGPT.QuickSort.BookExampleCode.T6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSortRandomOrderArray() {
        QuickSort sorter = new QuickSort();
        int[] arr = {5, 2, 8, 1, 7};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 7, 8}, arr);
    }

    @Test
    public void testSortDuplicateValues() {
        QuickSort sorter = new QuickSort();
        int[] arr = {3, 1, 3, 2, 2, 1, 3};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3, 3}, arr);
    }
}
