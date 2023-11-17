package Copilot.QuickSort.PromptOnly.T4;

import org.junit.Test;
import static org.junit.Assert.*;
public class QuickSortTest {

    @Test
    public void testSort() {
        int[] input = { 5, 7, 3, 9, 1, 2, 4, 8, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        QuickSort sorter = new QuickSort();
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSort2() {
        int[] input = { 5, 7, 3, 9, 1, 2, 4, 8, 6, 10 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        QuickSort sorter = new QuickSort();
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSort3() {
        int[] input = { 5, 7, 3, 9, 1, 2, 4, 8, 6, 10, 11 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11 };
        QuickSort sorter = new QuickSort();
        sorter.sort(input);
        assertArrayEquals(expected, input);
    }
}