package ChatGPT.BinarySearch.PromptOnly.T10;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchElementFound() {
        // Test when the element is found in the middle of the array
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(5, sortedNumbers);
        assertTrue(result);
    }

    @Test
    public void testBinarySearchElementNotFound() {
        // Test when the element is not found in the array
        int[] sortedNumbers = {2, 4, 6, 8, 10};
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(7, sortedNumbers);
        assertFalse(result);
    }

    @Test
    public void testBinarySearchEmptyArray() {
        // Test when the array is empty
        int[] sortedNumbers = {};
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(5, sortedNumbers);
        assertFalse(result);
    }
}
