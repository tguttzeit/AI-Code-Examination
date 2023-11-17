package Copilot.QuickSort.BookExampleCode.T2;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void setUp() throws Exception {
        quickSort = new QuickSort();
    }

    @Test
    public void testQuickSort() {
        int[] numbers = { 3, 1, 2, 4, 5 };
        quickSort.sort(numbers);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, numbers);
    }

    @Test
    public void testQuickSortWithOneElement() {
        int[] numbers = { 1 };
        quickSort.sort(numbers);
        assertArrayEquals(new int[] { 1 }, numbers);
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] numbers = {};
        quickSort.sort(numbers);
        assertArrayEquals(new int[] {}, numbers);
    }
}