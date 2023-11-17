package Copilot.QuickSort.BookExampleCode.T7;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        int[] numbers = { 5, 2, 1, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSort2() {
        int[] numbers = { 5, 2, 1, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSort3() {
        int[] numbers = { 5, 2, 1, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testQuickSort4() {
        int[] numbers = { 5, 2, 1, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertArrayEquals(expected, numbers);
    }
}