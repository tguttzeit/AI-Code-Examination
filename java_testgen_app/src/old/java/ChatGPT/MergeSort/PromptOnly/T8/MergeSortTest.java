package ChatGPT.MergeSort.PromptOnly.T8;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    public void testMergeSortWithRandomArray() {
        int[] arr = { 5, 3, 1, 4, 2 };
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }
}
