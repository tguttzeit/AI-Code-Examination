package Copilot.QuickSort.PromptOnly.T6;

import org.junit.Test;
import static org.junit.Assert.*;
public class QuickSortTest {
    @Test
    public void testSort() {
        // Test case 1
        int[] arr1 = new int[]{2, 1, 3};
        QuickSort.sort(arr1);
        assertArrayEquals(new int[]{1, 2, 3}, arr1);

        // Test case 2
        int[] arr2 = new int[]{2, 1, 3, 5, 4};
        QuickSort.sort(arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr2);

        // Test case 3
        int[] arr3 = new int[]{2, 1, 3, 5, 4, 6, 7};
        QuickSort.sort(arr3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, arr3);
    }
}