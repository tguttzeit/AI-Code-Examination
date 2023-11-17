package ChatGPT.QuickSort.PromptOnly.T5;

import ChatGPT.QuickSort.PromptOnly.T10.QuickSort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        new QuickSort().sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRandomArray() {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        assertArrayEquals(expected, arr);
    }
}
