package ChatGPT.QuickSort.PromptOnly.T4;

import ChatGPT.QuickSort.PromptOnly.T10.QuickSort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        new QuickSort().sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortUnsortedArray() {
        int[] arr = { 5, 3, 1, 4, 2 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }
}
