package ChatGPT.BinarySearch.PromptOnly.T8;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        BinarySearch binarySearch = new BinarySearch();
        assertTrue(binarySearch.binarySearch(3, sortedNumbers));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] sortedNumbers = {1, 3, 5, 7, 9};
        BinarySearch binarySearch = new BinarySearch();
        assertFalse(binarySearch.binarySearch(4, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        BinarySearch binarySearch = new BinarySearch();
        assertFalse(binarySearch.binarySearch(3, sortedNumbers));
    }
}
