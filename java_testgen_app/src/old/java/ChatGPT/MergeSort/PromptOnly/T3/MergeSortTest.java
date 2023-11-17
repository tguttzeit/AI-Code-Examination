package ChatGPT.MergeSort.PromptOnly.T3;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    // Helper method to check if an array is sorted.
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    public void testMergeSortWithAlreadySortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
        assertTrue(isSorted(arr));
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] arr = { 5, 2, 9, 1, 5, 6 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 5, 5, 6, 9 }, arr);
        assertTrue(isSorted(arr));
    }
}
