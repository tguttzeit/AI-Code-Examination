package Copilot.QuickSort.BookExampleCode.T5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
public class QuickSortTest {
    @Test
    public void testSort() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort sorter = new QuickSort();
        sorter.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testSortWithNull() {
        int[] numbers = null;
        int[] expected = null;
        QuickSort sorter = new QuickSort();
        sorter.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] numbers = {};
        int[] expected = {};
        QuickSort sorter = new QuickSort();
        sorter.sort(numbers);
        assertArrayEquals(expected, numbers);
    }
}