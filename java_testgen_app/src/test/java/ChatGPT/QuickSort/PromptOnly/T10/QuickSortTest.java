package ChatGPT.QuickSort.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class QuickSortTest {

    // Helper method to check if an array is sorted
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSortEmptyArray() {
        int[] inputArray = {};
        new QuickSort().sort(inputArray);
        assertArrayEquals(new int[] {}, inputArray);
    }

    @Test
    public void testSortAlreadySortedArray() {
        int[] inputArray = { 1, 2, 3, 4, 5 };
        new QuickSort().sort(inputArray);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, inputArray);
        // Additionally, check if the array is sorted
        assertTrue(isSorted(inputArray));
    }

    @Test
    public void testSortRandomArray() {
        int[] inputArray = { 5, 1, 4, 2, 3 };
        new QuickSort().sort(inputArray);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, inputArray);
        // Additionally, check if the array is sorted
        assertTrue(isSorted(inputArray));
    }
}
