package ChatGPT.QuickSort.AIGenerated.T10;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {};
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 1, 4, 2, 3};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }
}
