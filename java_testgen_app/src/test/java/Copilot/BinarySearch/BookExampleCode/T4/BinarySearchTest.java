package Copilot.BinarySearch.BookExampleCode.T4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9, 11};
        // test case 1: find the number in the array
        assertTrue(binarySearch.binarySearch(3, sortedNumbers));
        // test case 2: find the number not in the array
        assertFalse(binarySearch.binarySearch(8, sortedNumbers));
        // test case 3: find the number out of the array
        assertFalse(binarySearch.binarySearch(12, sortedNumbers));
    }
}