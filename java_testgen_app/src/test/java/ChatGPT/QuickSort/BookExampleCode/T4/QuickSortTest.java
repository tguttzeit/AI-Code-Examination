package ChatGPT.QuickSort.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {};
        int[] expected = {};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }
}
