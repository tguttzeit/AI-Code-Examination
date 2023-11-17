package ChatGPT.QuickSort.BookExampleCode.T8;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {};
        int[] expected = {};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testReverseSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }
}
