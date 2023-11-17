package Copilot.QuickSort.BookExampleCode.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class QuickSortTest {

    @Test
    public void testSort() {
        int[] numbers = { 5, 4, 3, 2, 1 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
        assertEquals(3, numbers[2]);
        assertEquals(4, numbers[3]);
        assertEquals(5, numbers[4]);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] numbers = { -5, -4, -3, -2, -1 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertEquals(-5, numbers[0]);
        assertEquals(-4, numbers[1]);
        assertEquals(-3, numbers[2]);
        assertEquals(-2, numbers[3]);
        assertEquals(-1, numbers[4]);
    }

    @Test
    public void testSortWithDuplicateNumbers() {
        int[] numbers = { 5, 5, 5, 5, 5 };
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        assertEquals(5, numbers[0]);
        assertEquals(5, numbers[1]);
        assertEquals(5, numbers[2]);
        assertEquals(5, numbers[3]);
        assertEquals(5, numbers[4]);
    }
}