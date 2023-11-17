package Copilot.QuickSort.AIGenerated.T2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testQuickSortWithNegativeNumbers() {
        int[] arr = {-5, -4, -3, -2, -1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, arr);
    }

    @Test
    public void testQuickSortWithEmptyArray() {
        int[] arr = {};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testQuickSortWithOneElement() {
        int[] arr = {1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void testQuickSortWithTwoElements() {
        int[] arr = {2, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    public void testQuickSortWithTwoEqualElements() {
        int[] arr = {1, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1}, arr);
    }

    @Test
    public void testQuickSortWithThreeElements() {
        int[] arr = {3, 2, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    public void testQuickSortWithThreeEqualElements() {
        int[] arr = {1, 1, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 1}, arr);
    }
}