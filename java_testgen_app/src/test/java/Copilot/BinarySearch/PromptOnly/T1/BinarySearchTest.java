package Copilot.BinarySearch.PromptOnly.T1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch bs = new BinarySearch();
        int[] sortedNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertTrue(bs.binarySearch(2, sortedNumbers));
        assertTrue(bs.binarySearch(5, sortedNumbers));
        assertTrue(bs.binarySearch(9, sortedNumbers));
        assertFalse(bs.binarySearch(10, sortedNumbers));
        assertFalse(bs.binarySearch(-1, sortedNumbers));
    }
}