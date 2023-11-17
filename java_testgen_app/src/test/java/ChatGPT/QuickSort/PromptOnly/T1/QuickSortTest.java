package ChatGPT.QuickSort.PromptOnly.T1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testSortWithEmptyArray() {
        int[] inputArray = {};
        int[] expectedArray = {};
        quickSort.sort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testSortWithSortedArray() {
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] expectedArray = {1, 2, 3, 4, 5};
        quickSort.sort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void testSortWithUnsortedArray() {
        int[] inputArray = {5, 3, 1, 4, 2};
        int[] expectedArray = {1, 2, 3, 4, 5};
        quickSort.sort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }
}
