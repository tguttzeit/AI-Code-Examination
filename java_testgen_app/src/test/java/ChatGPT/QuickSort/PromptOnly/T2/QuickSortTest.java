package ChatGPT.QuickSort.PromptOnly.T2;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortWithEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {};
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 3, 1, 4, 2};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }
}
