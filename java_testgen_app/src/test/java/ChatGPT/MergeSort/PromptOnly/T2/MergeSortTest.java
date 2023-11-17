package ChatGPT.MergeSort.PromptOnly.T2;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSortWithEmptyArray() {
        int[] arr = {};
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    public void testMergeSortWithSortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    public void testMergeSortWithUnsortedArray() {
        int[] arr = { 5, 3, 1, 4, 2 };
        mergeSort.mergeSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }
}
