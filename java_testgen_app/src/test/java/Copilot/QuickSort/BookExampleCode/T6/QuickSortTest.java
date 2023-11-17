package Copilot.QuickSort.BookExampleCode.T6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = { 3, 2, 5, 1, 9, 4, 8, 6, 7 };
        quickSort.sort(numbers);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(numbers));
    }

    @Test
    public void testQuickSortWithNegativeNumbers() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = { -3, 2, -5, 1, 9, -4, 8, 6, 7 };
        quickSort.sort(numbers);
        assertEquals("[-5, -4, -3, 1, 2, 6, 7, 8, 9]", Arrays.toString(numbers));
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = {};
        quickSort.sort(numbers);
        assertEquals("[]", Arrays.toString(numbers));
    }
}