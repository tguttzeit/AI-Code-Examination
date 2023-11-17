package Copilot.BinarySearch.BookExampleCode.T5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();

        int[] sortedNumbers = {1, 2, 3, 4, 5};
        assertTrue(binarySearch.binarySearch(1, sortedNumbers));
        assertFalse(binarySearch.binarySearch(6, sortedNumbers));

        sortedNumbers = {1, 2, 3, 4};
        assertTrue(binarySearch.binarySearch(3, sortedNumbers));
        assertFalse(binarySearch.binarySearch(5, sortedNumbers));

        sortedNumbers = {1, 2, 3, 4, 5, 6};
        assertTrue(binarySearch.binarySearch(6, sortedNumbers));
        assertFalse(binarySearch.binarySearch(7, sortedNumbers));
    }
}