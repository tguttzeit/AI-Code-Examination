package ChatGPT.QuickSort.AIGenerated.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortRandomArray() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
