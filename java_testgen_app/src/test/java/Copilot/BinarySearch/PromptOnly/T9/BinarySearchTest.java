package Copilot.BinarySearch.PromptOnly.T9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = { 1, 2, 3, 4, 5 };
        assertTrue(new BinarySearch().binarySearch(1, sortedNumbers));
        assertTrue(new BinarySearch().binarySearch(2, sortedNumbers));
        assertTrue(new BinarySearch().binarySearch(3, sortedNumbers));
        assertTrue(new BinarySearch().binarySearch(4, sortedNumbers));
        assertTrue(new BinarySearch().binarySearch(5, sortedNumbers));
        assertFalse(new BinarySearch().binarySearch(6, sortedNumbers));
        assertFalse(new BinarySearch().binarySearch(0, sortedNumbers));
    }
}
