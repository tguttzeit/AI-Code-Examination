package Copilot.QuickSort.AIGenerated.T7;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Test
    public void testSort() {
        int[] arr = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithNegativeValues() {
        int[] arr = { -5, -3, -6, -2, -1, -9, -4, -8, -7 };
        int[] expected = { -9, -8, -7, -6, -5, -4, -3, -2, -1 };

        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithIdenticalValues() {
        int[] arr = { 5, 5, 5, 5, 5, 5, 5, 5, 5 };
        int[] expected = { 5, 5, 5, 5, 5, 5, 5, 5, 5 };

        quickSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

}