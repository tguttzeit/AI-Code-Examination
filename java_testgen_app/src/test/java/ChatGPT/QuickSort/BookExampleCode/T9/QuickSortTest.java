package ChatGPT.QuickSort.BookExampleCode.T9;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {};
        quickSort.sort(input);
        int[] expected = {};
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortAlreadySortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {1, 2, 3, 4, 5};
        quickSort.sort(input);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSortUnsortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] input = {5, 1, 4, 2, 3};
        quickSort.sort(input);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, input);
    }
}
