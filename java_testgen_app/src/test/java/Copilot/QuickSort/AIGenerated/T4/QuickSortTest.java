package Copilot.QuickSort.AIGenerated.T4;

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
    public void testSort() {
        int[] arr = {5, 2, 1, 3, 6, 4};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithNegativeValues() {
        int[] arr = {-5, 2, 1, 3, -6, 4};
        quickSort.sort(arr);
        int[] expected = {-6, -5, 1, 2, 3, 4};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithDuplicates() {
        int[] arr = {5, 2, 1, 3, 6, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5, 5, 6};
        assertArrayEquals(expected, arr);
    }
}