package Copilot.BinarySearch.PromptOnly.T2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        assertTrue(BinarySearch.binarySearch(1, sortedNumbers));
        assertTrue(BinarySearch.binarySearch(2, sortedNumbers));
        assertFalse(BinarySearch.binarySearch(10, sortedNumbers));
        assertFalse(BinarySearch.binarySearch(0, sortedNumbers));
    }
}