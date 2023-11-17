package Copilot.QuickSort.AIGenerated.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    private QuickSort sorter;

    @Before
    public void init() {
        sorter = new QuickSort();
    }

    @Test
    public void testSort() {
        int[] arr = { 5, 2, 4, 6, 1, 3 };

        sorter.sort(arr);

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr);
    }

    @Test
    public void testSortWithNegativeNumbers() {
        int[] arr = { 5, -2, 4, 6, 1, 3 };

        sorter.sort(arr);

        assertArrayEquals(new int[] { -2, 1, 3, 4, 5, 6 }, arr);
    }

    @Test
    public void testSortWithDuplicates() {
        int[] arr = { 5, 2, 4, 6, 1, 3, 5 };

        sorter.sort(arr);

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 5, 6 }, arr);
    }

    private void assertArrayEquals(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}