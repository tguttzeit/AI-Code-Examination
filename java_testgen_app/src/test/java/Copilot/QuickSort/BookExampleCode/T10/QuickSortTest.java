package Copilot.QuickSort.BookExampleCode.T10;

import org.junit.Test;

import static org.junit.Assert.*;
public class QuickSortTest {
    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithOneElement() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = { 5 };
        int[] expected = { 5 };
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] numbers = {};
        int[] expected = {};
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }
}