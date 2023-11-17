package ChatGPT.QuickSort.BookExampleCode.T2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void testSortEmptyArray() {
        int[] arr = {};
        quickSort.sort(arr);
        int[] expected = {};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortRandomArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort.sort(arr);
        int[] expected = {1, 2, 5, 5, 6, 9};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testSortReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort.sort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, arr);
    }

    // Add more test cases as needed
}
