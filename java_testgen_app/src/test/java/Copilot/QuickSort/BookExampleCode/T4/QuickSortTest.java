package Copilot.QuickSort.BookExampleCode.T4;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testSort() {
        int[] numbers = { 3, 1, 2 };
        quickSort.sort(numbers);
        int[] expected = { 1, 2, 3 };
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] numbers = { -3, -1, -2 };
        quickSort.sort(numbers);
        int[] expected = { -3, -2, -1 };
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] numbers = {};
        quickSort.sort(numbers);
        int[] expected = {};
        assertArrayEquals(expected, numbers);
    }

}