package ChatGPT.QuickSort.AIGenerated.T7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
