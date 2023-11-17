package Copilot.QuickSort.BookExampleCode.T8;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        int[] numbers = { 9, 2, 5, 1, 0, 7, 8, 6, 3, 4 };
        int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithOneElement() {
        int[] numbers = { 1 };
        int[] expected = { 1 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithTwoElements() {
        int[] numbers = { 2, 1 };
        int[] expected = { 1, 2 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }
}