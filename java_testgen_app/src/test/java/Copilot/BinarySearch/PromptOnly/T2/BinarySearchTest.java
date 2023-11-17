package Copilot.BinarySearch.PromptOnly.T2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] sortedNumbers = { 1, 2, 3, 4, 5 };
        assertTrue(new BinarySearch().binarySearch(1, sortedNumbers));
        assertTrue(new BinarySearch().binarySearch(2, sortedNumbers));
        assertFalse(new BinarySearch().binarySearch(10, sortedNumbers));
        assertFalse(new BinarySearch().binarySearch(0, sortedNumbers));
    }
}