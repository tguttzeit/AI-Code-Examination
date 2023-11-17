package Copilot.BinarySearch.PromptOnly.T5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(3, sortedNumbers));
        assertFalse(binarySearch.binarySearch(6, sortedNumbers));
        assertTrue(binarySearch.binarySearch(1, sortedNumbers));
    }
}