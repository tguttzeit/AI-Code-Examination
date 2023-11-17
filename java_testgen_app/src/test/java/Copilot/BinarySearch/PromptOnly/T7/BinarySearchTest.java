package Copilot.BinarySearch.PromptOnly.T7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        BinarySearch bs = new BinarySearch();
        assertTrue(bs.binarySearch(1, sortedNumbers));
        assertTrue(bs.binarySearch(2, sortedNumbers));
        assertTrue(bs.binarySearch(3, sortedNumbers));
        assertTrue(bs.binarySearch(4, sortedNumbers));
        assertTrue(bs.binarySearch(5, sortedNumbers));
        assertFalse(bs.binarySearch(6, sortedNumbers));
    }
}