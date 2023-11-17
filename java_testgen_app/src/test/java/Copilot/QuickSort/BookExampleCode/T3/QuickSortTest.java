package Copilot.QuickSort.BookExampleCode.T3;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    private int[] numbers;
    private QuickSort quickSort;

    @Before
    public void setUp() throws Exception {
        quickSort = new QuickSort();
    }

    @Test
    public void testSort() throws Exception {
        numbers = new int[] {5, 4, 3, 2, 1};
        quickSort.sort(numbers);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, numbers);
    }

    @Test
    public void testSortWithDuplicateNumbers() throws Exception {
        numbers = new int[] {5, 4, 3, 3, 1};
        quickSort.sort(numbers);
        assertArrayEquals(new int[] {1, 3, 3, 4, 5}, numbers);
    }

    @Test
    public void testSortWithNegativeNumbers() throws Exception {
        numbers = new int[] {-5, -4, -3, -2, -1};
        quickSort.sort(numbers);
        assertArrayEquals(new int[] {-5, -4, -3, -2, -1}, numbers);
    }
}