package ChatGPT.BinarySearch.PromptOnly.T7;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    // Test case 1: Value exists in the array
    @Test
    public void testBinarySearchValueExists() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};

        // Search for an existing value (e.g., 7)
        boolean result = binarySearch.binarySearch(7, sortedNumbers);

        assertTrue(result);
    }

    // Test case 2: Value does not exist in the array
    @Test
    public void testBinarySearchValueDoesNotExist() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {2, 4, 6, 8, 10};

        // Search for a value that does not exist in the array (e.g., 7)
        boolean result = binarySearch.binarySearch(7, sortedNumbers);

        assertFalse(result);
    }

    // Test case 3: Empty array
    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};

        // Search in an empty array
        boolean result = binarySearch.binarySearch(5, sortedNumbers);

        assertFalse(result);
    }
}
