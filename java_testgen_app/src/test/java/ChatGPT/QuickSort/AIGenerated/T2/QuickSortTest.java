package ChatGPT.QuickSort.AIGenerated.T2;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortWithEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {};
        quickSort.sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithRandomArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 3, 1, 4, 2};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortWithDuplicateValues() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 5, 3, 1, 3};
        quickSort.sort(arr);
        int[] expected = {1, 3, 3, 5, 5};
        assertArrayEquals(expected, arr);
    }
}
