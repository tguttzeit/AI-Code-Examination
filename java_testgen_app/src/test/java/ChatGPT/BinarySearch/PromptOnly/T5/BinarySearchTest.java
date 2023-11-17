package ChatGPT.BinarySearch.PromptOnly.T5;

import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertTrue(binarySearch.binarySearch(5, sortedNumbers));
    }

    @Test
    public void testBinarySearchNotFound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertFalse(binarySearch.binarySearch(11, sortedNumbers));
    }

    @Test
    public void testBinarySearchEmptyArray() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedNumbers = {};
        assertFalse(binarySearch.binarySearch(5, sortedNumbers));
    }
}
