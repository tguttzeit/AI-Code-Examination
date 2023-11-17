package ChatGPT.BinarySearch.BookExampleCode.T5;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 3, 5, 7, 9};

        assertTrue(binarySearch.binarySearch(3, sortedNumbers)); // Element exists
        assertTrue(binarySearch.binarySearch(1, sortedNumbers)); // Element exists
        assertTrue(binarySearch.binarySearch(9, sortedNumbers)); // Element exists
    }

    @Test
    public void testBinarySearchNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {2, 4, 6, 8, 10};

        assertFalse(binarySearch.binarySearch(1, sortedNumbers)); // Element does not exist
        assertFalse(binarySearch.binarySearch(11, sortedNumbers)); // Element does not exist
        assertFalse(binarySearch.binarySearch(7, new int[]{})); // Empty array
    }

    @Test
    public void testBinarySearchEdgeCases() {
        BinarySearch binarySearch = new BinarySearch();

        // Single-element array
        assertTrue(binarySearch.binarySearch(42, new int[]{42}));

        // Large array
        int[] sortedNumbers = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            sortedNumbers[i] = i * 2; // Even numbers from 0 to 1999998
        }
        assertTrue(binarySearch.binarySearch(1000000, sortedNumbers)); // Element exists
        assertFalse(binarySearch.binarySearch(999999, sortedNumbers)); // Element does not exist
    }
}
