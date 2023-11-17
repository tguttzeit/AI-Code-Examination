package ChatGPT.QuickSort.PromptOnly.T7;

import ChatGPT.QuickSort.PromptOnly.T10.QuickSort;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testSortWithEmptyArray() {
        int[] arr = {};
        new QuickSort().sort(arr);
        int[] expected = {};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortWithUnsortedArray() {
        int[] arr = { 5, 2, 9, 1, 5 };
        new QuickSort().sort(arr);
        int[] expected = { 1, 2, 5, 5, 9 };
        assertArrayEquals(expected, arr);
    }
}
