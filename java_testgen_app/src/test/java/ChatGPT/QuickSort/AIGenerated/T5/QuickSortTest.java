package ChatGPT.QuickSort.AIGenerated.T5;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortWithSortedArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithReversedArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {3, 1, 4, 2, 5};
        int[] expected = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
