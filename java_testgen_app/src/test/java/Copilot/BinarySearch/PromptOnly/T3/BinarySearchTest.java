package Copilot.BinarySearch.PromptOnly.T3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        BinarySearch binarySearch = new BinarySearch();
        assertTrue(binarySearch.binarySearch(1, sortedNumbers));
        assertTrue(binarySearch.binarySearch(2, sortedNumbers));
        assertTrue(binarySearch.binarySearch(3, sortedNumbers));
        assertTrue(binarySearch.binarySearch(4, sortedNumbers));
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
        assertFalse(binarySearch.binarySearch(6, sortedNumbers));
    }
}