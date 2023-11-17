package Copilot.BinarySearch.PromptOnly.T9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = { 1, 2, 3, 4, 5 };
        assertTrue(BinarySearch.binarySearch(1, sortedNumbers));
        assertTrue(BinarySearch.binarySearch(2, sortedNumbers));
        assertTrue(BinarySearch.binarySearch(3, sortedNumbers));
        assertTrue(BinarySearch.binarySearch(4, sortedNumbers));
        assertTrue(BinarySearch.binarySearch(5, sortedNumbers));
        assertFalse(BinarySearch.binarySearch(6, sortedNumbers));
        assertFalse(BinarySearch.binarySearch(0, sortedNumbers));
    }
}