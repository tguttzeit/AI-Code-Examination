package Copilot.QuickSort.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void testSort() {
        QuickSort qs = new QuickSort();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {3, 1, 4, 5, 2};
        qs.sort(arr1);
        qs.sort(arr2);
        qs.sort(arr3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr3);
    }
}