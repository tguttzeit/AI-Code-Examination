package Copilot.QuickSort.PromptOnly.T5;

import org.junit.Test;
import static org.junit.Assert.*;
public class QuickSortTest {
    @Test
    public void testSort() {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSort_EmptyArray() {
        int[] array = new int[]{};
        int[] expected = new int[]{};
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] array = new int[]{5};
        int[] expected = new int[]{5};
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

}