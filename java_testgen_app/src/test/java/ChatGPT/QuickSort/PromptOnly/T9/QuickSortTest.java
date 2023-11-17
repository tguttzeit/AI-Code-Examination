package ChatGPT.QuickSort.PromptOnly.T9;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortSortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortRandomArray() {
        int[] input = {4, 2, 5, 1, 3};
        int[] expected = {1, 2, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        assertArrayEquals(expected, input);
    }
}
