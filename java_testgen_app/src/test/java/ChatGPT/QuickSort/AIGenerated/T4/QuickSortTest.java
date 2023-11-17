package ChatGPT.QuickSort.AIGenerated.T4;

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
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortRandomArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort.sort(arr);
        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, arr);
    }
}
