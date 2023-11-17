package ChatGPT.BinarySearch.PromptOnly.T9;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    // Test case 1: Element is present in the middle of the array.
    @Test
    public void testBinarySearchElementPresent() {
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        int x = 5;
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(x, sortedNumbers);
        assertTrue(result);
    }

    // Test case 2: Element is not present in the array.
    @Test
    public void testBinarySearchElementNotPresent() {
        int[] sortedNumbers = {2, 4, 6, 8, 10};
        int x = 7;
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(x, sortedNumbers);
        assertFalse(result);
    }

    // Test case 3: Array is empty.
    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        int x = 3;
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.binarySearch(x, sortedNumbers);
        assertFalse(result);
    }
}
