package ChatGPT.QuickSort.AIGenerated.T9;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] arr = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithRandomArray() {
        int[] arr = {3, 1, 4, 2, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }
}
