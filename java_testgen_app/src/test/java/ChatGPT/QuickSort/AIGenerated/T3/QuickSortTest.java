package ChatGPT.QuickSort.AIGenerated.T3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {};
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort.sort(arr);
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortDuplicateValues() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 2, 5, 1, 5, 2};
        quickSort.sort(arr);
        int[] expected = {1, 2, 2, 5, 5, 5};
        assertArrayEquals(expected, arr);
    }
}
