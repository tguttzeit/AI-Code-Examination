package ChatGPT.BinarySearch.AIGenerated.T5;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {
    // Test case 1: Target exists in the array
    @Test
    public void testBinarySearch_TargetExists() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9};
        int target = 5;
        boolean result = binarySearch.binarySearch(target, arr);
        assertTrue(result);
    }

    // Test case 2: Target does not exist in the array
    @Test
    public void testBinarySearch_TargetDoesNotExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 7, 9};
        int target = 6;
        boolean result = binarySearch.binarySearch(target, arr);
        assertFalse(result);
    }

    // Test case 3: Empty array should return false
    @Test
    public void testBinarySearch_EmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {};
        int target = 5;
        boolean result = binarySearch.binarySearch(target, arr);
        assertFalse(result);
    }
}
