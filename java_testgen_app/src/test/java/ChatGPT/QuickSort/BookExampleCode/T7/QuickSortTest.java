package ChatGPT.QuickSort.BookExampleCode.T7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithRandomArray() {
        int[] arr = {5, 1, 9, 3, 7};
        int[] expected = {1, 3, 5, 7, 9};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithDuplicateValues() {
        int[] arr = {4, 2, 4, 1, 4};
        int[] expected = {1, 2, 4, 4, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
