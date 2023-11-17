package Copilot.QuickSort.AIGenerated.T6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {3, 2, 1, 5, 4};
        quickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSortWithTwoElements() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {2, 1};
        quickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void testSortWithOneElement() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {1};
        quickSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void testSortWithEmptyArray() {
        QuickSort quickSort = new QuickSort();
        int[] arr = {};
        quickSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}