package ChatGPT.BinarySearch.PromptOnly.T3;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();

        boolean result = binarySearch.binarySearch(5, sortedNumbers);

        assertTrue(result);
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinarySearch binarySearch = new BinarySearch();

        boolean result = binarySearch.binarySearch(11, sortedNumbers);

        assertFalse(result);
    }

    @Test
    public void testBinarySearchEmptyArray() {
        int[] sortedNumbers = {};
        BinarySearch binarySearch = new BinarySearch();

        boolean result = binarySearch.binarySearch(42, sortedNumbers);

        assertFalse(result);
    }
}
