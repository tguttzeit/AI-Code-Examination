package ChatGPT.QuickSort.BookExampleCode.T5;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {};
        int[] expected = {};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testQuickSortSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testQuickSortRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }
}
