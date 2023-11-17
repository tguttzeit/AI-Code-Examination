package Copilot.QuickSort.PromptOnly.T9;

import ChatGPT.QuickSort.PromptOnly.T10.QuickSort;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {
    private int[] array;

    @Before
    public void setUp() {
        array = new int[] { 5, 4, 3, 2, 1 };
    }

    @Test
    public void testSort() {
        new QuickSort().sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
    }

    @Test
    public void testSortWithEmptyArray() {
        array = new int[] {};
        new QuickSort().sort(array);
        assertEquals(0, array.length);
    }

    @Test
    public void testSortWithOneElement() {
        array = new int[] { 1 };
        new QuickSort().sort(array);
        assertEquals(1, array[0]);
    }
}