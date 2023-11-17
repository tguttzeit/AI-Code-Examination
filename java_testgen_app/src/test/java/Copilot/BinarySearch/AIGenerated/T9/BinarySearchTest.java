package Copilot.BinarySearch.AIGenerated.T9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5};

        // Test case 1: Target found
        assertTrue(binarySearch.binarySearch(3, arr));

        // Test case 2: Target not found
        assertFalse(binarySearch.binarySearch(6, arr));

        // Test case 3: Empty array
        assertFalse(binarySearch.binarySearch(1, new int[]{}));
    }
}