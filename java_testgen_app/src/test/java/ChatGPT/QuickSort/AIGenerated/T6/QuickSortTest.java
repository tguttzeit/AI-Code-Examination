package ChatGPT.QuickSort.AIGenerated.T6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        QuickSort quickSort = new QuickSort();

        // Test Case 1: Test with a sorted array
        int[] arr1 = {1, 2, 3, 4, 5};
        quickSort.sort(arr1);
        int[] expectedArr1 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr1, arr1);

        // Test Case 2: Test with a reverse-sorted array
        int[] arr2 = {5, 4, 3, 2, 1};
        quickSort.sort(arr2);
        int[] expectedArr2 = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr2, arr2);

        // Test Case 3: Test with a random array
        int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        quickSort.sort(arr3);
        int[] expectedArr3 = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        assertArrayEquals(expectedArr3, arr3);
    }
}
